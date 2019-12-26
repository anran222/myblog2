package jpcap;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class JpcapPacket extends JFrame implements ItemListener,ActionListener{
	private JTextArea infoText;
	private JButton button;
	public JpcapPacket() {
		JPanel totalPanel=new JPanel();
		totalPanel.setLayout(new GridLayout(0,1));
		JPanel panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel degreeLabel=new JLabel("抓包");
		button=new JButton("开始");
		button.addItemListener((ItemListener) this);
		button.addActionListener((ActionListener) this);
		panel1.add(degreeLabel);
		panel1.add(button);
		totalPanel.add(panel1);
		infoText=new JTextArea(20,10);
		infoText.setLineWrap(true);
		JScrollPane jsp=new JScrollPane(infoText);
		this.add(totalPanel,"North");
		this.add(jsp,"Center");
		this.setTitle("网络分析");
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		JButton obj=(JButton)e.getSource();
		/*--------------	第一步绑定网络设备       --------------*/
		NetworkInterface[] devices = JpcapCaptor.getDeviceList();
		//JpcapCator是利用网卡获取数据包,getDeviceList()方法可以返回一组NetworkInterface
		for (NetworkInterface n : devices) {
			infoText.append(n.name + "     |     " + n.description+"\n");
		}
		JpcapCaptor jpcap = null;
		//JpcapCator是利用网卡获取数据包，JpcapCator可以捕获数据包
		int caplen = 1522;
		//数据包最大长度为1500
		boolean promiscCheck = true;
		try {
			jpcap = JpcapCaptor.openDevice(devices[0], caplen, promiscCheck, 50);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
		/*----------第二步抓包-----------------*/
		int i = 0;
		while (i < 5) {
			Packet packet = jpcap.getPacket();
			//创建一个包对象，并赋值
			if (packet instanceof IPPacket && ((IPPacket) packet).version == 4) {
				i++;
				infoText.append("----------------------IP---------------------"+"\n");
				IPPacket ip = (IPPacket) packet;
				//计算IP头部长度
				infoText.append("区分服务: 0");
				infoText.append("总长度：" + ip.length+"\n");
				infoText.append("标识：" + ip.ident+"\n");
				infoText.append("MF: " + ip.more_frag+"\n");
				infoText.append("DF: " + ip.dont_frag+"\n");
				infoText.append("片偏移：" + ip.offset+"\n");
				infoText.append("生存时间：" + ip.hop_limit+"\n");
				//输出相关数据
				String protocol = "";
				//初始为空
				switch (new Integer(ip.protocol)) {
				case 1:
					protocol = "ICMP";
					break;
				case 2:
					protocol = "IGMP";
					break;
				case 6:
					protocol = "TCP";
					break;
				case 8:
					protocol = "EGP";
					break;
				case 9:
					protocol = "IGP";
					break;
				case 17:
					protocol = "UDP";
					break;
				case 41:
					protocol = "IPv6";
					break;
				case 89:
					protocol = "OSPF";
					break;
				default:
					System.out.println("错误");
					break;
				}
				infoText.append("协议：" + protocol+"\n");
				//输出相关数据
				if(packet instanceof TCPPacket) {
					infoText.append("----------------------TCP------------------------"+"\n");
					TCPPacket tcp = (TCPPacket) packet;
					infoText.append("源端口：" + tcp.src_port+"\n");
					infoText.append("目的端口：" + tcp.dst_port+"\n");
					infoText.append("序号：" + tcp.sequence+"\n");
					infoText.append("确认号：" + tcp.ack_num+"\n");
					infoText.append("数据偏移：" + tcp.offset+"\n");
					infoText.append("保留：0");
					infoText.append("紧急URG：" + tcp.urg+"\n");
					infoText.append("确认ACK：" + tcp.ack+"\n");
					infoText.append("推送PSH：" + tcp.psh+"\n");
					infoText.append("复位RST：" + tcp.rst+"\n");
					infoText.append("同步SYN：" + tcp.syn+"\n");
					infoText.append("终止FIN：" + tcp.fin+"\n");
					infoText.append("窗口：" + tcp.window+"\n");
					infoText.append("紧急指针：" + tcp.urgent_pointer+"\n");
					infoText.append("选项：" + tcp.option+"\n");
				}
			}
		}
		infoText.append("----------------------------------------------");
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
package com.intejor.voicecontroller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class SendData extends Thread {
    private String sIP;
    private int sPORT;
    private String data;

    public SendData(String sIP, int sPORT) {
        this.sIP = sIP;
        this.sPORT = sPORT;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void run() {
        try {
            //UDP 통신용 소켓 생성
            DatagramSocket socket = new DatagramSocket();
            //서버 주소 변수
            InetAddress serverAddr = InetAddress.getByName(sIP);

            //보낼 데이터 생성
            byte[] buf = data.getBytes();

            //패킷으로 변경
            DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, sPORT);

            //패킷 전송!
            socket.send(packet);
        } catch (Exception e) {

        }
    }
}

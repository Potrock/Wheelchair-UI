package sample;


import gnu.io.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

class ArduinoChatter {

    private Enumeration portList;
    private CommPortIdentifier portId;
    private String message;
    private SerialPort serialPort;
    private OutputStream outputStream;


    ArduinoChatter(String msg) {
        this.message = msg;
        portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

                if (portId.getName().equals("COM4")) {
                    try {
                        serialPort = (SerialPort) portId.open("Wheelchair", 2000);
                        Thread.sleep(4000);
                    } catch (PortInUseException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        outputStream = serialPort.getOutputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    } catch (UnsupportedCommOperationException e) {
                        e.printStackTrace();
                    }
                    try {
                        outputStream.write(message.getBytes());
                        System.out.println(message);
                        outputStream.close();
                        serialPort.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

}

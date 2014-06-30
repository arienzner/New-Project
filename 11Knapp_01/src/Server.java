
 // Server.java

 // import java.net.ServerSocket;
 // import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

 public class Server {
	private final int iServerPort = 9131;
    private final int iEmuPort = 9130;
//kslfdjaoksjdfkljlkfdjklas
	private final String sEmuIp = "127.0.0.1"; // localhost
    private ServerSocket serverSocket = null;
    private  Socket outSocket = null,
    				inSocket = null;

    public void setConnection() throws Exception {
    	//Serversocket Client<-Emu
        serverSocket = new ServerSocket(iServerPort);
        //ClientSocket Client->Emu

        System.out.println("connect to emu...");
        outSocket = new Socket(sEmuIp,iEmuPort);

        //tell Emu, which port client is listening
        System.out.println("send handshake...");
        String sHandshake = "emuConnect,127.0.0.1,9131";
        sendToEmu(sHandshake);

        //await connection  Emu->Client
        System.out.println("wait for handshake...");
        inSocket = serverSocket.accept(); // blocked till Client is registrated
        System.out.println("connection established...");

    }

	public String receiveFromEmu() throws IOException {
		String sBuffer = "";

		for (boolean isEnd = false; !isEnd;) {
			// receive next block
			sBuffer = sBuffer + receiveNextPartFromEmu(inSocket);

			int iPos = sBuffer.indexOf((char) 10);
			// if block is complete (ends with "\n") then end is reached
			if (iPos > 0) {
				isEnd = true;
			}
		}
		return sBuffer;
	}

    //---send block to Emu---
    public void sendToEmu( String sMessage) throws IOException {
        PrintWriter printWriter =
           new PrintWriter(
               new OutputStreamWriter(
                   outSocket.getOutputStream()));
       printWriter.print(sMessage + (char)10);
       printWriter.flush();
    }


    //---await message from Emu---
    private String receiveNextPartFromEmu(Socket socket) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        char[] buffer = new char[1024];
        int iLength = bufferedReader.read(buffer, 0, 1024);
        String sMessage = new String(buffer, 0, iLength);
        return sMessage;
    }



 }
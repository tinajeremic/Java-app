/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Klasa;
import domain.Polaznik;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Tina
 */
public class ThreadClient extends Thread{
    
    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        
        try {
            switch (request.getOperation()) {
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) request.getData();
                    Administrator ulogovani = ServerController.getInstance().login(administrator);
                    response.setData(ulogovani);
                    break;
                case Operation.ADD_POLAZNIK:
                    ServerController.getInstance().addPolaznik((Polaznik) request.getData());
                    break;
                case Operation.GET_ALL_POLAZNIK:
                    response.setData(ServerController.getInstance().getAllPolaznik());
                    break;
                case Operation.DELETE_POLAZNIK:
                    ServerController.getInstance().deletePolaznik((Polaznik) request.getData());
                    break;
                case Operation.UPDATE_POLAZNIK:
                    ServerController.getInstance().updatePolaznik((Polaznik) request.getData());
                    break;
                case Operation.ADD_KLASA:
                    ServerController.getInstance().addKlasa((Klasa) request.getData());
                    break;
                case Operation.GET_ALL_CLAN_KLASE:                    
                    response.setData(ServerController.getInstance().getAllClanKlase((Klasa) request.getData()));
                    break;
                case Operation.GET_ALL_KATEGORIJA:
                    response.setData(ServerController.getInstance().getAllKategorija());
                    break;
                case Operation.GET_ALL_KLASA:
                    response.setData(ServerController.getInstance().getAllKlasa());
                    break;
                case Operation.DELETE_KLASA:
                    ServerController.getInstance().deleteKlasa((Klasa) request.getData());
                    break;
                case Operation.UPDATE_KLASA:
                    ServerController.getInstance().updateKlasa((Klasa) request.getData());
                    break;
                
                default:
                    return null;
            }
        }catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }
    
    
}

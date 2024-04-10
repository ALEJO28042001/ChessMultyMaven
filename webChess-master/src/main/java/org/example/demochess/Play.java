package org.example.demochess;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Board;
import model.Position;
import model.Utils;
import org.example.entities.ModelPerson;

@WebServlet(name = "Play", value = "/Play")
public class Play extends HttpServlet {
    private Board board;
    private Gson gson;

    public void init() {
    	this.board = Utils.createGame();
        this.gson = new Gson();
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	response.setContentType("text/html");
        // Get PrintWriter object
   	    PrintWriter out = response.getWriter();
           
           out.println("<!DOCTYPE html>\n"
           		+ "<html lang='en'>\n"
           		+ "\n"
           		+ "<head>\n"
           		+ "    <meta charset='UTF-8'>\n"
           		+ "    <title>Chess Game</title>\n"
           		+ "    <link rel='stylesheet' href='css/style.css'>\n"
           		+ "</head>\n"
           		+ "\n"
           		+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>\n"
           		+ "\n"
           		+ "<body>\n"
           		+ "\n"
           		+ "<div class='container'>\n"
           		+ "    <h1>JCHESS</h1>\n"
           		+ "    <ul>\n"
           		+ "    \n"
           		+ "        <div class='div' id='row0'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b000' onclick='getResponse(0,0)'></li>\n"
           		+ "            <li class='box' id='b001' onclick='getResponse(0,1)'></li>\n"
           		+ "            <li class='box' id='b002' onclick='getResponse(0,2)'></li>\n"
           		+ "            <li class='box' id='b003' onclick='getResponse(0,3)'></li>\n"
           		+ "            <li class='box' id='b004' onclick='getResponse(0,4)'></li>\n"
           		+ "            <li class='box' id='b005' onclick='getResponse(0,5)'></li>\n"
           		+ "            <li class='box' id='b006' onclick='getResponse(0,6)'></li>\n"
           		+ "            <li class='box' id='b007' onclick='getResponse(0,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row1'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b100' onclick='getResponse(1,0)'></li>\n"
           		+ "            <li class='box' id='b101' onclick='getResponse(1,1)'></li>\n"
           		+ "            <li class='box' id='b102' onclick='getResponse(1,2)'></li>\n"
           		+ "            <li class='box' id='b103' onclick='getResponse(1,3)'></li>\n"
           		+ "            <li class='box' id='b104' onclick='getResponse(1,4)'></li>\n"
           		+ "            <li class='box' id='b105' onclick='getResponse(1,5)'></li>\n"
           		+ "            <li class='box' id='b106' onclick='getResponse(1,6)'></li>\n"
           		+ "            <li class='box' id='b107' onclick='getResponse(1,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row2'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b200' onclick='getResponse(2,0)'></li>\n"
           		+ "            <li class='box' id='b201' onclick='getResponse(2,1)'></li>\n"
           		+ "            <li class='box' id='b202' onclick='getResponse(2,2)'></li>\n"
           		+ "            <li class='box' id='b203' onclick='getResponse(2,3)'></li>\n"
           		+ "            <li class='box' id='b204' onclick='getResponse(2,4)'></li>\n"
           		+ "            <li class='box' id='b205' onclick='getResponse(2,5)'></li>\n"
           		+ "            <li class='box' id='b206' onclick='getResponse(2,6)'></li>\n"
           		+ "            <li class='box' id='b207' onclick='getResponse(2,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row3'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b300' onclick='getResponse(3,0)'></li>\n"
           		+ "            <li class='box' id='b301' onclick='getResponse(3,1)'></li>\n"
           		+ "            <li class='box' id='b302' onclick='getResponse(3,2)'></li>\n"
           		+ "            <li class='box' id='b303' onclick='getResponse(3,3)'></li>\n"
           		+ "            <li class='box' id='b304' onclick='getResponse(3,4)'></li>\n"
           		+ "            <li class='box' id='b305' onclick='getResponse(3,5)'></li>\n"
           		+ "            <li class='box' id='b306' onclick='getResponse(3,6)'></li>\n"
           		+ "            <li class='box' id='b307' onclick='getResponse(3,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row4'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b400' onclick='getResponse(4,0)'></li>\n"
           		+ "            <li class='box' id='b401' onclick='getResponse(4,1)'></li>\n"
           		+ "            <li class='box' id='b402' onclick='getResponse(4,2)'></li>\n"
           		+ "            <li class='box' id='b403' onclick='getResponse(4,3)'></li>\n"
           		+ "            <li class='box' id='b404' onclick='getResponse(4,4)'></li>\n"
           		+ "            <li class='box' id='b405' onclick='getResponse(4,5)'></li>\n"
           		+ "            <li class='box' id='b406' onclick='getResponse(4,6)'></li>\n"
           		+ "            <li class='box' id='b407' onclick='getResponse(4,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row5'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b500' onclick='getResponse(5,0)'></li>\n"
           		+ "            <li class='box' id='b501' onclick='getResponse(5,1)'></li>\n"
           		+ "            <li class='box' id='b502' onclick='getResponse(5,2)'></li>\n"
           		+ "            <li class='box' id='b503' onclick='getResponse(5,3)'></li>\n"
           		+ "            <li class='box' id='b504' onclick='getResponse(5,4)'></li>\n"
           		+ "            <li class='box' id='b505' onclick='getResponse(5,5)'></li>\n"
           		+ "            <li class='box' id='b506' onclick='getResponse(5,6)'></li>\n"
           		+ "            <li class='box' id='b507' onclick='getResponse(5,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row6'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b600' onclick='getResponse(6,0)'></li>\n"
           		+ "            <li class='box' id='b601' onclick='getResponse(6,1)'></li>\n"
           		+ "            <li class='box' id='b602' onclick='getResponse(6,2)'></li>\n"
           		+ "            <li class='box' id='b603' onclick='getResponse(6,3)'></li>\n"
           		+ "            <li class='box' id='b604' onclick='getResponse(6,4)'></li>\n"
           		+ "            <li class='box' id='b605' onclick='getResponse(6,5)'></li>\n"
           		+ "            <li class='box' id='b606' onclick='getResponse(6,6)'></li>\n"
           		+ "            <li class='box' id='b607' onclick='getResponse(6,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "\n"
           		+ "        <div class='div' id='row7'>\n"
           		+ "\n"
           		+ "            <li class='box' id='b700' onclick='getResponse(7,0)'></li>\n"
           		+ "            <li class='box' id='b701' onclick='getResponse(7,1)'></li>\n"
           		+ "            <li class='box' id='b702' onclick='getResponse(7,2)'></li>\n"
           		+ "            <li class='box' id='b703' onclick='getResponse(7,3)'></li>\n"
           		+ "            <li class='box' id='b704' onclick='getResponse(7,4)'></li>\n"
           		+ "            <li class='box' id='b705' onclick='getResponse(7,5)'></li>\n"
           		+ "            <li class='box' id='b706' onclick='getResponse(7,6)'></li>\n"
           		+ "            <li class='box' id='b707' onclick='getResponse(7,7)'></li>\n"
           		+ "\n"
           		+ "        </div>\n"
           		+ "    </ul>\n"
           		+ "\n"
           		+ "    <h2 id='tog'>White's Turn</h2>\n"
           		+ "    <h2 id='start-game' onclick='getResponse('no', 'no')'>Start Game</h2>\n"
           		+ "</div>\n"
           		+ "\n"
           		+ "</body>\n"
           		+ "<script type='text/javascript' src='/webChess-master/src/main/webapp/js/Controller.js'></script>\n"
           		+ "<script type='text/javascript' src='js/ViewFunctions.js'></script>\n"
           		+ "\n"
           		+ "\n"
           		+ "</html>\n"
           		+ "");
    	
           
        String xString = request.getParameter("x");
        String yString = request.getParameter("y");
        String playerColor = request.getParameter("playerColor");


            if((xString.equals("no") && yString.equals("no")) || (!playerColor.equals(this.board.getPlayerInTurn()))){

                response.setContentType("application/json");
                String json = gson.toJson(board);
                response.getWriter().write(json);

            }

            else {

                int x = Integer.parseInt(xString);
                int y = Integer.parseInt(yString);
                System.out.println(x);
                System.out.println(y);
                this.board.setPosition(new Position(x, y));
                response.setContentType("application/json");
                String json = gson.toJson(board);
                response.getWriter().write(json);

            }



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    }

    public void destroy() {
    }
}
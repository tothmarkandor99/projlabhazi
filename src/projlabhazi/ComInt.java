package projlabhazi;

import java.util.ArrayList;

public class ComInt { //interactive command interpreter for testing

	public static void main(String[] args) {
		ArrayList<Panda> Pandas = new ArrayList<Panda>();
		ArrayList<Tile> Tiles = new ArrayList<Tile>();
		ArrayList<Object> Objects = new ArrayList<Object>();
		int counter = 0;
		
		String line = System.console().readLine();
		String[] input = line.split(" ");
		while (true) {
			if (input.length < 1)
				continue;
			switch (input[0].trim().toLowerCase()) {
			case "exit":
				return;
			case "newgame":
				
				break;
			case "createtile":
				
				break;
			case "deletetile" :
				
				break;
			case "addneighbour" :
				
				break;
			case "removeneighbour" :
				
				break;
			case "createpanda" :
				
				break;
			case "deletepanda" :
				
				break;
			case "setentrance" :
				
				break;
			case "createobject" :
				
				break;
			case "deleteobject" :
				
				break;
			case "putpanda" :
				
				break;
			case "putobject" :
				
				break;
			case "step" :
				
				break;
			default:
				break;
			}
		}

	}

}

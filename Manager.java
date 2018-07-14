package TicTacToe;

import java.util.Scanner;

public class Manager {
	private static player p1; 
	private static player p2;
	private static Board board;
	public static void TicTacToe(){
		Scanner s=new Scanner(System.in);
		p1=create_player();
		p2=create_player();
		while(p1.getsymbol()==p2.getsymbol()){
			System.out.println("Entered same symbol");
			p2=create_player();
		}
		board=new Board(p1.getsymbol(), p2.getsymbol());
		int status=board.INCOMPLETE;
		Boolean turn=true;
		while(status==board.INCOMPLETE||status==board.INVALID){
			if(turn){
			    System.out.println("player "+p1.getname()+"'s turn");
			    System.out.println("enter x");
			    int x=s.nextInt();
		    	System.out.println("enter y");
			    int y=s.nextInt();
			    status=board.move(p1.getsymbol(),x,y);
			    if(status==board.INCOMPLETE){
			    	turn=false;
			        board.print();
			    }
			    else if(status==board.INVALID){
			    	System.out.println("invalid move!! try again");
			    }
			}
			else{
				System.out.println("player "+p2.getname()+"'s turn");
			    System.out.println("enter x");
			    int x=s.nextInt();
		    	System.out.println("enter y");
			    int y=s.nextInt();
			    status=board.move(p2.getsymbol(),x,y);
			    if(status==board.INCOMPLETE){
			    	turn=true;
			    	board.print();
			    }
			    else if(status==board.INVALID){
			    	System.out.println("invalid move!! try again");
			    }
			}
		}
		board.print();
		if(status==board.PLAYER_1){
			System.out.println("              PLAYER1 WON");
			return;
		}
		if(status==board.PLAYER_2){
			System.out.println("               PLAYER2 WON");
			return;
		}
		else{
			System.out.println("               DRAW");
			return;
		}
		
	}
	private static player create_player() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name of first player");
		String name=s.nextLine();
		System.out.println("enter symbol for first player");
		char symbol=s.nextLine().charAt(0);
		player p=new player(name, symbol);
		return p;
	}
	public static void main(String[] args) {
		TicTacToe();
		
	}
	

}

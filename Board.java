package TicTacToe;

public class Board {
	char[][] board;
	int boardSize=3;
	int count=0;
	char p1Symbol;
	char p2Symbol;
	
	public final static int PLAYER_1=1;
	public final static int PLAYER_2=2;
	public final static int DRAW=3;
	public final static int INCOMPLETE=4;
	public final static int INVALID=5;
	public Board(char p1Symbol,char p2Symbol) {
	    board=new char[boardSize][boardSize];
	    for(int i=0;i<boardSize;i++){
	    	for(int j=0;j<boardSize;j++){
	    		board[i][j]=' ';
	    	}
	    }
	    this.p1Symbol=p1Symbol;
	    this.p2Symbol=p2Symbol;
	}
	public int move(char getsymbol, int x, int y) {
		if(x>=boardSize ||x<0 ||y>=boardSize||y<0||board[x][y]!=' '){
			return INVALID;
		}
		board[x][y]=getsymbol;
		count++;
			if(board[0][y]==board[1][y]&&board[0][y]==board[2][y]){
				return getsymbol == p1Symbol ?PLAYER_1:PLAYER_2;
			}
			if(board[x][0]==board[x][1]&&board[x][1]==board[x][2]){
				return getsymbol== p2Symbol?PLAYER_1:PLAYER_2;
			}
			if(board[0][0]!=' '&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]){
				return getsymbol== p2Symbol?PLAYER_1:PLAYER_2;
			}
			if(board[1][1]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
				return getsymbol== p2Symbol?PLAYER_1:PLAYER_2;
			}
		if(count==boardSize*boardSize){
			return DRAW;
		}
		return INCOMPLETE;
	}
	public void print() {
		System.out.println("-------------------------");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(" | "+board[i][j]+" | ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	
	

}

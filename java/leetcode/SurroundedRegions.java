package oj;

import java.util.List;

public class SurroundedRegions {
	class Posi {
		public Posi(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int x, y;
	}
	
	void ScanAndFlip(char[][] board, int offset) {
		int width = board[0].length - offset * 2;
		int height = board.length - offset * 2;
		
		boolean flip = false;
		for (int i = 0; i < width; ++i) {
			if (board[offset][offset + i] == 'O' && flip) 
				board[offset][offset + i] = 'F';
			else if (board[offset][offset + i] == 'F')
				flip = true;
			else 
				flip = false;
		}
		flip = false;
		for (int i = width - 1; i >= 0; --i) {
			if (board[offset][offset + i] == 'O' && flip) 
				board[offset][offset + i] = 'F';
			else if (board[offset][offset + i] == 'F')
				flip = true;
			else 
				flip = false;
		}
		
		flip = false;
		for (int i = 0; i < width; ++i) {
			if (board[offset + height - 1][offset + i] == 'O' && flip) 
				board[offset + height - 1][offset + i] = 'F';
			else if (board[offset + height - 1][offset + i] == 'F')
				flip = true;
			else 
				flip = false;
		}
		flip = false;
		for (int i = width - 1; i >= 0; --i) {
			if (board[offset + height - 1][offset + i] == 'O' && flip) 
				board[offset + height - 1][offset + i] = 'F';
			else if (board[offset + height - 1][offset + i] == 'F')
				flip = true;
			else 
				flip = false;
		}
		
		flip = false;
		for (int i = 0; i < height; ++i) {
			if (board[offset + i][offset] == 'O' && flip) 
				board[offset + i][offset] = 'F';
			else if (board[offset + i][offset] == 'F')
				flip = true;
			else 
				flip = false;
		}		
		flip = false;
		for (int i = height - 1; i >= 0; --i) {
			if (board[offset + i][offset] == 'O' && flip) 
				board[offset + i][offset] = 'F';
			else if (board[offset + i][offset] == 'F')
				flip = true;
			else 
				flip = false;
		}		
		
		
		flip = false;
		for (int i = 0; i < height; ++i) {
			if (board[offset + i][offset + width - 1] == 'O' && flip) 
				board[offset + i][offset] = 'F';
			else if (board[offset + i][offset] == 'F')
				flip = true;
			else 
				flip = false;
		}		
		flip = false;
		for (int i = height - 1; i >= 0; --i) {
			if (board[offset + i][offset] == 'O' && flip) 
				board[offset + i][offset] = 'F';
			else if (board[offset + i][offset] == 'F')
				flip = true;
			else 
				flip = false;
		}		
	}
	
	void FlipAndFindNewSeeds(char[][] board, int offset, List<Posi> outer_seed, List<Posi> new_seed) {
		int width = board[0].length - offset * 2;
		int height = board.length - offset * 2;
		
		for ()
	}
	
	void findOnBorder(char[][] board, int offset, List<Posi> seed_o, List<Posi> open_o) {
		int width = board[0].length - offset * 2;
		int height = board.length - offset * 2;
		
		

		List<Posi> next_seed;
		for (Posi s : seed_o) {
			if (s.x == offset) {
				for (int i = s.y - 1)
				
				// left
			} else if (s.y == offset) {
				// top 
			} else if (s.x = offset + width - 1) {
				// right
			} else {
				// bottom
			}
		}
	}
	
    public void solve(char[][] board) {
    	
        
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

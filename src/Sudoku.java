import java.util.Arrays;
public class Sudoku {
	public static void main(String[]args){
		
	    long startTime = (System.currentTimeMillis())*1000;
	    //int[] a = {11, 12, 13, 11, 14, 13, 12};
	    //int[] b = sort(a);
	    //System.out.println(Arrays.toString(b));  
	    
	    int[][] GRID = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
	    
	    //System.out.println(uniqueEntries(p[8]));
	    //System.out.println(Arrays.toString(getColumn(p,0)));
	    //System.out.println(Arrays.toString(flatten(p)));
	    //System.out.println(Arrays.toString(flatten(subGrid(p,3,3,3))));
	    //System.out.println(isValid(p));
	    //System.out.println(uniqueEntries(getColumn(p,8)));
	    //System.out.println(isColumn(p));
	    //System.out.println(isRow(p));
	    //System.out.println(isColumn(p));

	    //System.out.println(isSubgrid(p));
	    //System.out.println(uniqueEntries(flatten(subGrid(p,0,0,3))));  // test methods for each of the individual helper methods.
	    //System.out.println(isSudoku(p));
	    if(isSudoku(GRID)){
	    	System.out.println("Game over!");
	    	
	    }
	    else{
	    	
	    	System.out.println("Game in progress");
	    }
	    
	    long endTime   = (System.currentTimeMillis())*1000;
	    long totalTime = endTime - startTime;
	    System.out.println(totalTime);
	  }
	  // by calling new helper methods that we have created(isRow,isColumn,isSubgrid) , isSudoku returns true if and only if all helper methods return true.
	  public static boolean isSudoku(int[][] grid){
	    
            boolean result = false;
	    if(grid.length==9 && isValid(grid)==true){
	      if(isRow(grid)==true && isColumn(grid)==true && isSubgrid(grid)==true){   
	        
	    	  result = true;
	      }
	      else{
	        
	    	  result = false;
	      }
	    }
	   return result;
	  }
	  
	  public static boolean isColumn(int[][] grid){  //checks if each column contains unique entries.
	    
            boolean result = true;
	    if(grid.length==9 && isValid(grid)==true){
	      for(int i=0;i<grid[0].length;i++){
	          if(uniqueEntries(getColumn(grid,i))==false){   // checks if each row contains unique no.s.
	            
	        	  result = false;
	          
	          }
	      }
	    }
	   return result;   
	  } 
	  public static boolean isRow(int[][] grid){  //checks if each row contains unique entries.
	      
	    boolean result = true;
	      if(grid.length==9 && isValid(grid)==true){
	        for(int i=0;i<b.length;i++){
	          if(uniqueEntries(grid[i])==false){
	            
	        	  result = false;
	          }
	        }
	      }
	     return result;
	    }
	    public static boolean isSubgrid(int[][] grid){
	      
	    boolean result = true;
	      for(int w=0;w<3;w++){    //row no is fixed for subgrids at top.
	        if(uniqueEntries(flatten(subGrid(grid,0,3*w,3)))==false){ // 3 "if" conditions to check entries for each of the 3 subgrids in rows 0,3,6,
	          
	        	result = false;
	        }
	        if(uniqueEntries(flatten(subGrid(grid,3,3*w,3)))==false){
	          
	        	result = false;
	        }
	        if(uniqueEntries(flatten(subGrid(grid,6,3*w,3)))==false){
	          
	        	result = false;
	        }
	      }
	     return result;
	    }      
	    
	    public static boolean isValid(int[][] grid){
	    boolean result = true;
	    
	    for(int i=0;i<grid.length;i++){
	      for(int j=0;j<grid[0].length;j++){
	        if(grid[i][j]>9){
	          result = false;
	        }
	      }
	    }
	    return result;
	  }
	  // two for loops used so we can perform all possible comparisons of elements at different indices.
	  public static int[] sort(int[] array){  
	    
	    int[] b = new int[9];
	    for(int i =0;i<array.length;i++){
	      b[i] = array[i];
	    }
	    for(int i=0; i<b.length;i++){
	      for(int j =i+1; j<b.length;j++){
	       if(b[i]>b[j]){
	        
	        int temp = b[i];
	        b[i] = b[j];
	        b[j] = temp;
	       }
	      }
	    }   
	    return b;   
	  }
	  // takes an array of integers and checks if all entries are unique.
	  public static boolean uniqueEntries(int[] array){
	    
	    int[] sorted = sort(array);
	    boolean b = true;    
	    for(int i= 0; i<sorted.length;i++){
	      for(int j=i+1; j<sorted.length;j++){
	        if(sorted[i]==sorted[j]){
	          
	        	b = false;
	        }
	      }
	    }
	   return b;
	  }
	  // takes a 2d array representing the grid and returns the specified column from the grid. 
	  public static int[] getColumn(int[][] grid, int column){
	    
	    int a = 0;
	    int[] column = new int[9];
	    for(int row = 0; row<grid.length;row++){
	      
	      column[a] = grid[row][column];
	      a++;
	    }
	    return column; 
	  }
	  // takes a 2d array representing a grid(or subgrid) and returns its contents as a single array in the correct order. 
	  public static int[] flatten(int[][] grid){
	    
	    int index = 0;
	    int[] combined = new int[grid[0].length*grid.length];
	    for(int i =0; i<grid.length; i++){
	      for(int j = 0;j<grid[0].length;j++){
	        
	    	combined[index] = grid[i][j];
	        index++;
	      }
	    }
	   return combined;
	  }
	  // takes a 2d array representing a grid and returns a subgrid of a specific size(m*m) starting at the specified coordinate (i,j)
	  public static int[][] subGrid(int[][] grid,int i,int j,int m){
	    
	    int[][] subGrid = new int[m][m];
	    for(int x=0;x<m;x++){
	      for(int y=0;y<m;y++){
	        
	    	 subGrid[x][y] = grid[i+x][j+y];
	      }
	    }
	   return subGrid;  
	  }
	}

	  






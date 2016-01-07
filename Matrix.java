//Team Boba -- Anna Tolen, Bayle Smith-Salzberg, Kate Johnston
//APCS1 pd10
//HW55 -- Don't Think You Are, Know You Are
//2016-01-06

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;


    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];

    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];

    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length * matrix[0].length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];

    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return get(r,c) == null;

    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object retVal = get(r,c);	
	matrix[r][c] = newVal;
	return retVal;

    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retVal = "";
	for (int i = 0; i < matrix.length;i++){
	    retVal+="\n";
	    for (int x = 0; x < matrix[0].length;x++){
		retVal+= matrix[i][x] + "\t";
	    }
	}
	return retVal;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	boolean retVal = false;
	if (rightSide instanceof Matrix){
	    Matrix other = (Matrix)rightSide;
	    retVal = other.matrix.length == matrix.length &&
		other.matrix[0].length == matrix[0].length;
	    if (retVal){
		for (int i = 0; i < matrix.length;i++){
		    for (int x = 0; x < matrix[0].length;x++){
			retVal = matrix[i][x] == other.matrix[i][x];
		    }
		}
	    }
	}
	return retVal;
    }


    //swap two columns of this matrix 
    //(0,0) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2 ) {
	for (int i = 0; i < matrix[0].length; i++){
	    Object old = this.get(i,c2);
	    Object nu = this.get(i,c1);
	    this.set(i,c1,old);
	    this.set(i,c2,nu);
	}
    }


    //swap two rows of this matrix 
    //(0,0) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	for (int i = 0; i < matrix.length; i++){
	    Object old = this.get(r2,i);
	    Object nu = this.get(r1,i);
	    this.set(r1,i,old);
	    this.set(r2,i,nu);
	}
    }

    //returns if matrix is full
    public boolean isFull() {
	for ( int x = 0 ; x < matrix.length ; x++ ) {
	    for ( int y = 0 ; y < matrix[x].length ; y++ ) {
		if ( isEmpty(x,y) ) { return false; }
	    }
	}
	return true;
    }
       
    public Object[] getRow( int r ) {
	Object[] ret = new Object[matrix.length];
	for( int i = 0; i < matrix.length; i++ ) {
	    ret[i] = matrix[r][i];
	}
	return ret;
    }


    public Object[] setRow( int r, Object[] newRow ) {
	Object[] hold = getRow(r);
	for( int i = 0; i < matrix.length; i++ ) {
	    set(r,i,newRow[i]);
	}
	return hold;
    }

    public Object[] getCol( int c ) {
	Object[] ret = new Object[matrix[0].length];
	for( int i = 0; i < matrix[0].length; i++ ) {
	    ret[i] = matrix[i][c];
	}
	return ret;
    }

    
    public Object[] setCol( int c, Object[] newCol ) {
	Object[] hold = getCol(c);
	for( int i = 0; i < matrix[0].length; i++ ) {
	    set(i,c,newCol[i]);
	}
	return hold;
    }

	
    public void transpose(){
	for (int i = 0; i < matrix.length; i++){
	    Object[] oldR = getRow(i);
	    Object[] oldC = getCol(i);
	    setRow(i,oldC);
	    setCol(i,oldR);
	}
    }
    public boolean contains( Object o ){
	for (int i = 0; i <matrix.length;i++){
	    for (int x = 0; x <matrix[0].length; x++){
		if (get(i,x).equals(o)){
		    return true;
		}
	    }
	}
	return false;
    }
	    

	
//main method for testing
    public static void main( String[] args ) {
	Matrix george = new Matrix(4);
	Matrix ginny = new Matrix();
	for (int i=0; i<4;i++) {
	    for (int j=0; j<4; j++) {
		george.set(i,j,i-j+5);
	    }
	}
	System.out.println("george:\n" + george.toString() +
			   "\nginny:\n" + ginny.toString());

	//quick test for isFull()=======
	System.out.println("george.isFull():\t" + george.isFull() +
			   "\nginny.isFull():\t" + ginny.isFull());

	//===========GET/SETrows=========
	Object[] newRow = new Object[4];
	for (int i=0; i<4; i++) newRow[i] = i+1;
	System.out.println("\ngeorge.getRow(2):\t");
	for (int i=0; i<4; i++) System.out.print((george.get(2,i) + ","));
	System.out.println("\nAFTER george.setRow(2, [1,2,3,4]):\t");
	george.setRow(2,newRow);
	for (int i=0; i<4; i++) System.out.print((george.get(2,i) + ","));

	//===========GET/SET cols=========
	Object[] newCol = new Object[4];
	for (int i=0; i<4; i++) newCol[i] = 20-i;
	System.out.println("\n\ngeorge.getCol(2):\t");
	for (int i=0; i<4; i++) System.out.print((george.get(2,i)) + ",");
	System.out.println("\nAFTER george.setCol(r, [20,19,18,17] )");
	george.setCol(2, newCol);
	for (int i=0; i<4; i++) System.out.print((george.get(2,i) + ","));
	System.out.println("\n\ngeorge:\n" + george.toString());

	//===========transpose() + contains=========
	george.transpose();
	System.out.println("AFTER TRANSPOSAL:\n" + george.toString());

	System.out.println("george.contains(1):\t" + george.contains(1) +
			   "\ngeorge.contains(50):\t" + george.contains(50));
    }

}//end class Matrix

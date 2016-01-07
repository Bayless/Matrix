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
	for (int i = 0; i < matrix.length; i+){
	    Object[] oldR = getRow(i);
	    Object[] oldC = getCol(i);
	    setRow(i,oldC);
	    setCol(i,oldR);
	}
    }
	

    //main method for testing
    public static void main( String[] args ) {
	
	Matrix bayle = new Matrix();
	System.out.println(bayle);
	System.out.println(bayle.size());
	System.out.println(bayle.get(0,0));//expecting null, hasnt been filled yet
	bayle.set(0,1,"hola!");
	System.out.println(bayle);
	System.out.println(bayle.isEmpty(0,1));
	System.out.println(bayle.get(0,1));//expecting "hola!"
	
	Matrix caleb = new Matrix(6);
	System.out.println(caleb);
	System.out.println(caleb.size());
	System.out.println(caleb.get(0,0));//expecting null, hasnt been filled yet
	caleb.set(1,4,"hola!");
	System.out.println(caleb.isEmpty(1,4));//false
	System.out.println(caleb.isEmpty(1,1));//true
	System.out.println(caleb.get(1,4));//expecting "hola!"
	
	Matrix fayanne = caleb;
	System.out.println(fayanne);
	System.out.println(fayanne.equals(caleb));//true
	System.out.println(fayanne.equals(bayle));//false
	fayanne.set(4,5,"badG!");
	System.out.println(fayanne);
	fayanne.swapColumns(1,4);
	System.out.println(fayanne);
	fayanne.swapRows(5,4);
	System.out.println(fayanne);

	System.out.println(fayanne.isFull());
	
    }

}//end class Matrix

package comp1110.ass1;

import javax.tools.JavaCompiler;
import java.util.Arrays;

/**
 * An enumeration representing the four masks in the game hide.
 *
 * In the provided version of this class, each of the masks do not have any
 * associated state.  You may wish to add that.  You will then need to use
 * constructors to initialized that state.
 *
 * You may want to look at the 'Planet' example in the Oracle enum tutorial for
 * an example of how to associate state (radius, density in that case) with each
 * item in the enumeration.
 *
 * http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 */
public enum Mask {
    W("0,1,3,4,5,6,8","0,1,2,4,5,6,7","0,2,3,4,5,7,8","1,2,3,4,6,7,8","9,10,12,13,14,15,17","9,10,11,13,14,15,16","9,11,12,13,14,16,17","10,11,12,13,15,16,17","18,19,21,22,23,24,26","18,19,20,22,23,24,25","18,20,21,22,23,25,26","19,20,21,22,24,25,26","27,28,30,31,32,33,35","27,28,29,31,32,33,34","27,29,30,31,32,34,35","28,29,30,31,33,34,35"),
    X("0,2,3,5,6,7,8","0,1,2,3,6,7,8","0,1,2,3,5,6,8","0,1,2,5,6,7,8","9,11,12,14,15,16,17","9,10,11,12,15,16,17","9,10,11,12,14,15,17","9,10,11,14,15,16,17","18,20,21,23,24,25,26","18,19,20,21,24,25,26","18,19,20,21,23,24,26","18,19,20,23,24,25,26","27,29,30,32,33,34,35","27,28,29,30,33,34,35","27,28,29,30,32,33,35","27,28,29,32,33,34,35"),
    Y("1,2,3,4,5,6,7","0,1,3,4,5,7,8","1,2,3,4,5,6,7","0,1,3,4,5,7,8","10,11,12,13,14,15,16","9,10,12,13,14,16,17","10,11,12,13,14,15,16","9,10,12,13,14,16,17","19,20,21,22,23,24,25","18,19,21,22,23,25,26","19,20,21,22,23,24,25","18,19,21,22,23,25,26","28,29,30,31,32,33,34","27,28,30,31,32,34,35","28,29,30,31,32,33,34","27,28,30,31,32,34,35"),
    Z("0,2,3,4,5,6,8","0,1,2,4,6,7,8","0,2,3,4,5,6,8","0,1,2,4,6,7,8","9,11,12,13,14,15,17","9,10,11,13,15,16,17","9,11,12,13,14,15,17","9,10,11,13,15,16,17","18,20,21,22,23,24,26","18,19,20,22,24,25,26","18,20,21,22,23,24,26","18,19,20,22,24,25,26","27,29,30,31,32,33,35","27,28,29,31,33,34,35","27,29,30,31,32,33,35","27,28,29,31,33,34,35");     // These do not use any state (or constructors).  You may want to add them.
    //( 4 rotations in 1st quadrant : 4 rotations in 2nd quadrant : 4 rotations in 3rd quadrant : 4 rotations in 4th quadrant )

    /**
     * Return indicies corresponding to which board squares would be covered
     * by this mask given the provided placement.
     *
     * A placement encodes which of the four quadrants a mask is located in,
     * and rotations of the masks.  Masks may only be rotated, not be flipped
     * (the game does not allow them to be turned over).
     *
     * Masks W and X have four interesting rotations.   Masks Y and Z only have two
     * interesting rotations, the other two are isomorphic:  Mask Y and Z in rotation
     * A are indistinguishable from masks Y and Z in rotation C. Likewise Mask Y and Z
     * in rotation B are indistinguishable from masks Y and Z in rotation D.
     *
     * The placement character describes the place as follows:
     *    - letters 'A' to 'D' describe the first quadrant of the board,
     *      corresponding to board positions 0-8.
     *    - letters 'E' to 'H' describe the second quadrant of the board,
     *      corresponding to board positions 9-17.
     *    - letters 'I' to 'L' describe the third quadrant of the board,
     *      corresponding to board positions 18-26.
     *    - letters 'M' to 'P' describe the fourth quadrant of the board,
     *      corresponding to board positions 27-35.
     *    - letters 'A', 'E', 'I', and 'M' describe the mask upright
     *    - letters 'B', 'F', 'J', and 'N' describe the mask turned 90 degrees clockwise
     *    - letters 'C', 'G', 'K', and 'O' describe the mask turned 180 degrees
     *    - letters 'D', 'H', 'L', and 'P' describe the mask turned 270 degrees clockwise
     *
     * Examples:
     *
     *   Given the placement character 'A', the mask 'W' would return the indices: {0,1,3,4,5,6,8}.
     *   Given the placement character 'O', the mask 'X' would return the indices: {27,28,29,30,32,33,35}.
     *
     *
     * Hint: You can associate values with each entry in the enum using a constructor,
     * so you could use that to somehow encode the properties of each of the four masks.
     * Then in this method you could use the value to calculate the required indicies.
     *
     * See the 'Grade' enum given in the O2 lecture as part of the lecture code (live coding),
     * for an example of an enum with associated state and constructors.
     *
     * The tutorial here: http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
     * has an example of a Planet enum, which includes two doubles in each planet's
     * constructor representing the mass and radius.   Those values are used in the
     * surfaceGravity() method, for example.
     *
     * @param placement A character describing the placement of this mask, as per the above encoding
     * @return A set of indices corresponding to the board positions that would be covered by this mask
     */

    /*Variables for Task 4*/

    private String a,b,c,d;
    private String e,f,g,h;
    private String i,j,k,l;
    private String m,n,o,p;
    private String[] temp;
    private int[] indices = new int[7];


    /*Variables for Task 5*/

    private static char[] in;
    private static char[] positions;
    private static int[] indexW;
    private static int[] indexX;
    private static int[] indexY;
    private static int[] indexZ;
    private static String output;


    Mask(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p;
    }

    int[] getIndices(char placement) {
        // FIXME Task 4: implement code that correctly creates an array of integers specifying the indicies of masked pieces
        if(placement == 'A'){
            temp = Mask.this.a.split(",");              //use ',' to split original indices string and store it into a string array
            for(int z = 0; z < temp.length; z++){             //length of temp = length of original indices sequence
                indices[z]=Integer.valueOf(temp[z]);          //pass & convert each element(index) into int array
            }
            return indices;
        }
        else if(placement == 'B'){
            temp = Mask.this.b.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'C'){
            temp = Mask.this.c.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'D'){
            temp = Mask.this.d.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'E'){
            temp = Mask.this.e.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'F'){
            temp = Mask.this.f.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'G'){
            temp = Mask.this.g.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'H'){
            temp = Mask.this.h.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'I'){
            temp = Mask.this.i.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'J'){
            temp = Mask.this.j.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'K'){
            temp = Mask.this.k.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'L'){
            temp = Mask.this.l.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'M'){
            temp = Mask.this.m.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'N'){
            temp = Mask.this.n.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'O'){
            temp = Mask.this.o.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        else if(placement == 'P'){
            temp = Mask.this.p.split(",");
            for(int z = 0; z < temp.length; z++){
                indices[z]=Integer.valueOf(temp[z]);
            }
            return indices;
        }
        return indices;
    }

    /**
     * Mask an input string with a given string of mask positions.   The
     * four characters composing the mask position string describe the
     * positions and rotations of each of four masks.
     *
     * The first character in the string describes the position and rotation
     * of the 'W' mask.  The second, third and fourth describe the positions
     * of the 'X', 'Y', and 'Z' positions respectively.
     *
     * If the character is a space ' ', then that means that the given mask
     * is not used.   Otherwise the encoding described above in getIndices() is used.
     *
     * Hint: The values() method of any enum type will return an array of the values in the enum.
     *
     * Hint: You cannot change strings, but you can convert from strings to
     * char arrays (.toCharArray()), and you can create new strings from
     * char arrays.
     *
     * @param maskPositions A string describing the positions of each of the masks, as per above
     * @param input An input string of 36 characters
     * @return The result of masking the input with the given mask, with masked characters replaced
     * by Hide.EMPTY_CHAR ('.').
     */

    public static String maskString(String maskPositions, String input) {
        // FIXME Task 5: implement code that correctly creates a masked string according to the comment above
        output = "";                                    //initialize String output
        in = input.toCharArray();                       //convert input & pass the placement characters into char array
        positions = maskPositions.toCharArray();        //convert maskPositions to char array
        if(positions[0]!= ' '){                         //check if 1st char is EMPTY_CHAR
            indexW = Mask.W.getIndices(positions[0]);   //encode 1st placement character for mask W; save indices
            for(int z = 0; z < 7; z++){
                in[indexW[z]] = '.';                    //hide elements in the char array according to the indices
            }
        }

        if(positions[1]!= ' '){                         //check if the 2nd char is EMPTY_CHAR
            indexX = Mask.X.getIndices(positions[1]);   //encode 2nd placement character for mask X; save indices
            for(int z = 0; z < 7; z++){
                in[indexX[z]] = '.';                    //hide elements in the char array according to the indices
            }
        }

        if(positions[2]!=' '){                          //check if the 3rd char is EMPTY_CHAR
            indexY = Mask.Y.getIndices(positions[2]);   //encode 3rd placement character for mask Y; save indices
            for(int z = 0; z < 7; z++){
                in[indexY[z]] = '.';                    //hide elements in the char array according to the indices
            }
        }

        if(positions[3]!=' '){                          //check if the 4th char is EMPTY_CHAR
            indexZ = Mask.Z.getIndices(positions[3]);   //encode 4th placement character for mask Z; save indices
            for(int z = 0; z < 7; z++){
                in[indexZ[z]] = '.';                    //hide elements in the char array according to the indices
            }
        }

        output = new String(in);    //pass the elements in the char array to a String. **This statement was learnt
                                    //from tutor during'triangle' practice in lab 2. Practice has proven that by coding
                                    //this way, the output will ignore the char ",[]" and contain required char only
        return output;
    }
}

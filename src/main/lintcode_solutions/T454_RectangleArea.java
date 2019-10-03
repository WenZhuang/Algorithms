package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:48
 */
public class T454_RectangleArea {
    public class Rectangle {
        /*
         * Define two public attributes width and height of type int.
         */
        // write your code here
        private int width;
        private int height;

        /*
         * Define a constructor which expects two parameters width and height here.
         */
        // write your code here
        public Rectangle(int width, int height){
            this.width = width;
            this.height = height;
        }

        /*
         * Define a public method `getArea` which can calculate the area of the
         * rectangle and return.
         */
        // write your code here
        public int getArea(){
            return width * height;
        }
    }
}

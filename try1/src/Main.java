public class Main {
    private static final String colors[] = { "RED", "GREEN", "BLUE", "WHITE", "BLACK" };


    public static void main (String[]args){


        for(int i = 0; i<5; i++){

            Colors obj = (Colors)Factory.getColors(getRandomColor());
            obj.setX(getRandomX());
            obj.setY(getRandomY());
            obj.setRadius(20);
            obj.drawCircle();

        }

    }



    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }

}

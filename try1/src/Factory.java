
//FLYWEIGHT IMPLEMENTATION

import java.util.HashMap;

public class Factory {

    private static final HashMap circleMap = new HashMap();

    public static DrawAPI getColors (String color){
        Colors circleColors = (Colors) circleMap.get(color);

        if(circleColors == null){
            circleColors = new Colors(color);
            circleMap.put(color, circleColors);
            System.out.println("CREATING CIRCLE OF COLOR : " + color);

        }

        return circleColors;

    }



}

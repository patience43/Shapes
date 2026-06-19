package shapes; 

public class ShapesDemo {

    
    public static void printAreas(Shape[] shapes) {
        System.out.println("--- Printing Geometric Shape Areas ---");
        for (Shape s : shapes) {
            if (s != null) {
                
                System.out.printf("Shape Area: %,.2f | Details: %s\n", s.getArea(), s.toString());
            }
        }
    }

    
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) return null;
        
        Shape largestShape = shapes[0];
        for (Shape s : shapes) {
            if (s != null && s.getArea() > largestShape.getArea()) {
                largestShape = s;
            }
        }
        return largestShape;
    }

    public static void main(String[] args) {
    
        Shape[] shapeCollection = new Shape[3];

        try {
            shapeCollection[0] = new Circle("Red", true, 5.0);
            shapeCollection[1] = new Rectangle("Blue", false, 4.0, 6.0);
            shapeCollection[2] = new Triangle("Green", true, 3.0, 4.0, 5.0);
        } catch (InvalidShapeException e) {
            System.err.println("Error setting up baseline shapes: " + e.getMessage());
        }

        printAreas(shapeCollection);
        
        Shape champion = largest(shapeCollection);
        System.out.println("\n-> The shape with the largest area profile is: " + champion);

        System.out.println("\n--- Testing Custom Exception Catching ---");
 
        try {
            System.out.println("Attempting to create a triangle with invalid sides (1, 1, 100)...");
            Shape brokenTriangle = new Triangle("Yellow", true, 1.0, 1.0, 100.0);
        } catch (InvalidShapeException ex) {
            System.out.println(">>> Success! The invalid triangle was safely blocked: " + ex.getMessage());
        }
    }
}

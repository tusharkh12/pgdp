package pgdp.rectangles;

public class Vector2D {
	    private double y;
		private double x;



		public Vector2D(double x, double y) {
			this.y = y;
			this.x = x;
		}

		public double getX() {
			return x;
		}


		public void setX(double xpoint) {
			this.x = xpoint;

		}

		public double getY() {
		return y;
	    }


	public void setY(double ypoint) {
		this.y = ypoint;
	}

		public void add( Vector2D point2) {
			y = y + point2.y;
			x = x + point2.x;

		}

		public String toString() {
			return "(" + getX() + ", " + getY() + ")";

		}
	public static void main(String[] args) {


		/*
		 * This part is only for testing purposes and should not be changed.
		 */

		Vector2D myVector = new Vector2D(1.0, 2.0);
		if (myVector.toString().equals("[1.0, 2.0]"))
			System.out.println("The String seems to match. Good Job!");
		else {
			System.out.println("This is what you created: " + myVector);
			System.out.println("This is how it should be: [1.0, 2.0]");
			System.out.println("Better luck next time!");
		}

		/*
		 * Down here you might want to add code to create your own tests?
		 */

	}
	}
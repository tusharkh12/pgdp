package pgdp.rectangles;
public class Rectangle {

			private Vector2D topLeft;

			private Vector2D bottomRight;

			public Rectangle( Vector2D tl, Vector2D br) {

				this.bottomRight = br;

				this.topLeft = tl;

			}

			public String toString() {
				return "Rectangle spanned by points [" + topLeft.getX() + ", " + topLeft.getY() + "] and [" + bottomRight.getX()
						+ ", " + bottomRight.getY() + "].";
			}

			public double calculateArea() {
				double cAX = bottomRight.getX() - topLeft.getX();
				double cAY = topLeft.getY() - bottomRight.getY();
				double CA= cAX * cAY;
				return CA  ;
//CA= Calculate Area

			}

	public void shiftBy(Vector2D point2) {

				topLeft.add(point2);

		bottomRight.add(point2);
			}

			public static void main(String[] args) {

				/*
				 * This part is only for testing purposes and should not be changed.
				 *
				 * @TODO: Remove the comment symbols (Eclipse: Ctrl + Shift + C) and run the
				 * main-method for testing. If you have not implemented the constructor and
				 * toString-method, your program won't build!
				 */

		Vector2D tl = new Vector2D(0.0, 2.0), br = new Vector2D(2.0, 0.5);
		Vector2D point = new Vector2D(5, 5);
		Rectangle myRectangle = new Rectangle(tl, br);
		System.out.println(myRectangle.toString());
		System.out.println(myRectangle.calculateArea());
		myRectangle.shiftBy(point);
		System.out.println(myRectangle.toString());
		if (myRectangle.toString().equals("Rectangle spanned by points [0.0, 2.0] and [2.0, 0.5]."))
			System.out.println("The String seems to match. Good Job!");
		else {
			System.out.println("This is what you created: " + myRectangle);
			System.out.println("This is how it should be: Rectangle spanned by points [0.0, 2.0] and [2.0, 0.5].");
			System.out.println("Better luck next time!");
		}

				/*
				 * Down here you might want to add code to create your own tests?
				 */

			}

		}



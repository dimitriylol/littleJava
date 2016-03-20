package org;

public class Main {

    public static void main(String[] args) {
	    GameField myField = new GameField(3, 3);

        System.out.println("Empty field");
        System.out.println(myField);
        try {
            System.out.println("setting x to center");
            myField.setCell(1, 1, new ShapeX());
            System.out.println("setting o to topleft");
            myField.setCell(0, 0, new ShapeO());
            System.out.println(myField);
            System.out.println("setting x to center again");
            myField.setCell(1, 1, new ShapeX());
        } catch (FieldElementException e) {
            e.printStackTrace();
        }

    }
}

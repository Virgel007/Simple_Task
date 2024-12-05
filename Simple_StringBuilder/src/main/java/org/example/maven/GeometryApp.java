package org.example.maven;

import org.example.GeometricShapeCircle;
import org.example.GeometricShapeRectangle;
import org.example.GeometricShapeTriangle;
import org.example.GeometricUtils;

public class GeometryApp {

    public static void main(String[] args) {
        // создаем объекты различных геометрических фигур
        GeometricShapeCircle circle = new GeometricShapeCircle(5);
        GeometricShapeRectangle rectangle = new GeometricShapeRectangle(3, 4);
        GeometricShapeTriangle triangle = new GeometricShapeTriangle(3, 4, 5);

        // выводим информацию о площади и периметре
        System.out.println("Circle: area = " + circle.calculateArea() + ", perimeter = " + circle.calculatePerimeter());
        System.out.println("Rectangle: area = " + rectangle.calculateArea() + ", perimeter = " + rectangle.calculatePerimeter());
        System.out.println("Triangle: area = " + triangle.calculateArea() + ", perimeter = " + triangle.calculatePerimeter());

        // выводим информацию о площади и периметре для всех геометрических фигур
        System.out.println("Circle: area = " + GeometricUtils.convertToMeter(circle.calculateArea(), GeometricUtils.UnitOfLength.MM) + " mm , perimeter = " + GeometricUtils.convertToMeter(circle.calculatePerimeter(), GeometricUtils.UnitOfLength.MM) + " mm");
        System.out.println("Rectangle: area = " + GeometricUtils.convertToMeter(rectangle.calculateArea(), GeometricUtils.UnitOfLength.MM) + " mm , perimeter = " + GeometricUtils.convertToMeter(rectangle.calculatePerimeter(), GeometricUtils.UnitOfLength.MM) + " mm");
        System.out.println("Triangle: area = " + GeometricUtils.convertToMeter(triangle.calculateArea(), GeometricUtils.UnitOfLength.MM) + " mm , perimeter = " + GeometricUtils.convertToMeter(triangle.calculatePerimeter(), GeometricUtils.UnitOfLength.MM) + " mm");

    }
}

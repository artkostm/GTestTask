package by.geotesttask;

import by.geotesttask.errors.LogicalException;
import by.geotesttask.logic.TestTaskLogic;

import java.io.IOException;

/**
 * Created by Artsiom on 1/19/2015.
 */
public class GeoTestTask {

    public static void main(String[] args) throws LogicalException{
        TestTaskLogic.performTask(args);
    }

}

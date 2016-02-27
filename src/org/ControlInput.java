package org;

import static org.ViewResult.errorMessage;

/**
 * Created by dmytro on 27.02.16.
 */
public class ControlInput {
    DataProcess dataProcess = new DataProcess();

    private boolean oneElement(String[] inputArg) {
        return inputArg.length == 1;
    }

    public void checkInput(String[] inputArgs) {
        try {
            if (oneElement(inputArgs) && Integer.parseInt(inputArgs[0]) >= 0)
                dataProcess.process(Integer.parseInt(inputArgs[0]));
            else
                errorMessage(inputArgs);
        } catch (NumberFormatException err) {
            errorMessage(inputArgs);
        }
    }
}

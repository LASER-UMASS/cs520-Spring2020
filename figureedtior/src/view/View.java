package view;

import model.FigureModel;
import controller.FigureController;


public interface View 
{
    public void addController(FigureController controller);

    public void update(FigureModel model);
}

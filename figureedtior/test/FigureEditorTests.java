import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import model.FigureModel;


public class FigureEditorTests
{
    @Test
    public void testNewFigureModel() {
	FigureModel model = new FigureModel();
	Assert.assertNotNull(model);
	Assert.assertNull(model.getImage());
	Assert.assertNull(model.getCaption());
    }
}

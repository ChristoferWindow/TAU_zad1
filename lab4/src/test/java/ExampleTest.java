import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ExampleTest {
    private final float[] testGrades = {1.5F,3,5,5,4};//3.7
    @Test
    public void testGetAverage() {
        Grades grades = new Grades();
        grades.setGrades(this.testGrades);
        float average = grades.getAverage(grades.getGrades());

        assertEquals(4.0F, average,0.0);
    }

    @Test
    public void testIsMyMomHappyFromMyGrades() {
        Grades grades = mock(Grades.class);
        float[] testArray = {1,2,3,4,5};
        when(grades.getGrades()).thenReturn(testArray);
        then()
        assertEquals("Your mom is sad **crying**", , );
    }

    @Test
    public void testDoYouPassTau(){

    }
}
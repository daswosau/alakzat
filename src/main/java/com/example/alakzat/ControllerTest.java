package com.example.alakzat;

import org.junit.*;

public class ControllerTest {
    @Test public void testSave() {
        HelloController controller = new HelloController();
        //controller.printToFile();
    }

    public static boolean isRunningTest = false;

    @BeforeClass
    public static void testBeforeOnce() {
        System.out.println("testBeforeOnce");

    }

    @AfterClass
    public static void testAfterOnce() {
        System.out.println("testAfterOnce");
    }

    @Before
    public void testBefore() {
        isRunningTest = true;
    }

    @After
    public void testAfter() {
        isRunningTest = false;
    }

    @Test
    public void testMain() {
        HelloApplication.main(null);
    }

    @Test
    public void testStart() {
        isRunningTest = true;
        HelloApplication app = new HelloApplication();
        try {
            app.start(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
        isRunningTest = false;
    }

    public void testController() {
        HelloController controller = new HelloController();

        controller.selector();
        controller.setOutputImage(controller.selectShape + ", " + controller.selectColour);
        controller.addItem();
        controller.delItem();
        controller.saveList();
    }
}

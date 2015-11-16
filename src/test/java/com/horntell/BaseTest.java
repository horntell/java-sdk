package com.horntell;

import com.horntell.model.App;
import org.junit.Before;

/**
 * Created by dave on 15/11/15.
 */
public class BaseTest {

    @Before
    public void getBasicAuthCredentials(){

        App.init("d1soVNeGTbTHoAFKarI1vDIOQCvYljO3tsxs2yUy", "BdvuDEo5g6aeY9smQSlte4uxx9J361Nidx12SXOr");
        App.setBase("http://demo.api.horntell.com");
        App.setVersion("v1");
    }


}

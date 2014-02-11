package br.com.bitwaysystem;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


/**
 * Created by fsantiago on 04/02/14.
 */
public class SoapServices {


    private static final String NAMEESPACE = "http://webservice.bitwaysystem.com.br/";
    private static final String METHOD_NAME = "retrieveCookie";


    // Localhost para android
    //private static final String URL = "http://10.0.2.2:8988/context-root-JP010020/CustomerManagerSoapHttpPort";

    private static final String URL = "http://bitwaysystem.no-ip.org:9110/cookies";

    private static final String SOAP_ACTION = "retrieveCookie";

    @SuppressWarnings("deprecation")
    public String[] getFortuneCookie(CookieBean cookieTO) {

        String values[] = null;

        SoapObject soapObject = new SoapObject(NAMEESPACE, METHOD_NAME);



        PropertyInfo pi = new PropertyInfo();
        pi.setName("arg0");

        soapObject.addProperty(pi);
        soapObject.addProperty("cookieMessage", "");
        soapObject.addProperty("index", cookieTO.index);



        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);

        envelope.setAddAdornments(false);
        envelope.implicitTypes = true;
        envelope.dotNet = false;

        envelope.setOutputSoapObject(soapObject);

        HttpTransportSE transport = new HttpTransportSE(URL);

        try {

            transport.debug = true;
            transport.call(SOAP_ACTION, envelope);

            SoapObject result = (SoapObject) envelope.bodyIn;

            values = new String[result.getPropertyCount()];
            for (int i = 0; i < result.getPropertyCount(); i++) {
                values[i] = result.getProperty(i).toString();
            }

            Log.w("Minha app", "Invocou Web Service");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(transport.requestDump);
            System.out.println(transport.responseDump);
            System.out.println(e.getMessage());
        }
        return values;
    }

}

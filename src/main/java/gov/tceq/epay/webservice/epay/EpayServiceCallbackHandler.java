/**
 * EpayServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package gov.tceq.epay.webservice.epay;


/**
 *  EpayServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class EpayServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public EpayServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public EpayServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for epayUserLogout method
     * override this method for handling normal response from epayUserLogout operation
     */
    public void receiveResultepayUserLogout(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayUserLogoutResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayUserLogout operation
     */
    public void receiveErrorepayUserLogout(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayLoadBilledFees method
     * override this method for handling normal response from epayLoadBilledFees operation
     */
    public void receiveResultepayLoadBilledFees(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayLoadBilledFeesResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayLoadBilledFees operation
     */
    public void receiveErrorepayLoadBilledFees(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayGetStatus method
     * override this method for handling normal response from epayGetStatus operation
     */
    public void receiveResultepayGetStatus(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayGetStatusResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayGetStatus operation
     */
    public void receiveErrorepayGetStatus(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayGetStatusByVoucher method
     * override this method for handling normal response from epayGetStatusByVoucher operation
     */
    public void receiveResultepayGetStatusByVoucher(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayGetStatusByVoucherResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayGetStatusByVoucher operation
     */
    public void receiveErrorepayGetStatusByVoucher(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayLoadShoppingCart method
     * override this method for handling normal response from epayLoadShoppingCart operation
     */
    public void receiveResultepayLoadShoppingCart(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayLoadShoppingCartResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayLoadShoppingCart operation
     */
    public void receiveErrorepayLoadShoppingCart(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayUpdateVoucherStatus method
     * override this method for handling normal response from epayUpdateVoucherStatus operation
     */
    public void receiveResultepayUpdateVoucherStatus(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayUpdateVoucherStatusResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayUpdateVoucherStatus operation
     */
    public void receiveErrorepayUpdateVoucherStatus(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayUserLogin method
     * override this method for handling normal response from epayUserLogin operation
     */
    public void receiveResultepayUserLogin(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayUserLoginResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayUserLogin operation
     */
    public void receiveErrorepayUserLogin(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayGetPayments method
     * override this method for handling normal response from epayGetPayments operation
     */
    public void receiveResultepayGetPayments(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayGetPaymentsResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayGetPayments operation
     */
    public void receiveErrorepayGetPayments(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for epayPing method
     * override this method for handling normal response from epayPing operation
     */
    public void receiveResultepayPing(
        gov.tceq.epay.webservice.epay.EpayServiceStub.EpayPingResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from epayPing operation
     */
    public void receiveErrorepayPing(java.lang.Exception e) {
    }
}

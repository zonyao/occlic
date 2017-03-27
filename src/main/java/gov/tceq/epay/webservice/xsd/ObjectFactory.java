
package gov.tceq.epay.webservice.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.tceq.epay.webservice.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EpayPing_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayPing");
    private final static QName _EpayPingResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayPingResponse");
    private final static QName _EpayUserLogin_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayUserLogin");
    private final static QName _EpayUserLoginResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayUserLoginResponse");
    private final static QName _EpayUserLogout_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayUserLogout");
    private final static QName _EpayUserLogoutResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayUserLogoutResponse");
    private final static QName _EpayLoadShoppingCart_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayLoadShoppingCart");
    private final static QName _EpayLoadShoppingCartResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayLoadShoppingCartResponse");
    private final static QName _EpayGetStatus_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayGetStatus");
    private final static QName _EpayGetStatusResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayGetStatusResponse");
    private final static QName _EpayGetStatusByVoucher_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayGetStatusByVoucher");
    private final static QName _EpayGetStatusByVoucherResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayGetStatusByVoucherResponse");
    private final static QName _EpayUpdateVoucherStatus_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayUpdateVoucherStatus");
    private final static QName _EpayUpdateVoucherStatusResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayUpdateVoucherStatusResponse");
    private final static QName _EpayLoadBilledFees_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayLoadBilledFees");
    private final static QName _EpayLoadBilledFeesResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayLoadBilledFeesResponse");
    private final static QName _EpayGetPayments_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayGetPayments");
    private final static QName _EpayGetPaymentsResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "EpayGetPaymentsResponse");
    private final static QName _ErrorResponse_QNAME = new QName("http://webservice.epay.tceq.gov/xsd", "ErrorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.tceq.epay.webservice.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EpayPing }
     * 
     */
    public EpayPing createEpayPing() {
        return new EpayPing();
    }

    /**
     * Create an instance of {@link EpayPingResponse }
     * 
     */
    public EpayPingResponse createEpayPingResponse() {
        return new EpayPingResponse();
    }

    /**
     * Create an instance of {@link EpayUserLogin }
     * 
     */
    public EpayUserLogin createEpayUserLogin() {
        return new EpayUserLogin();
    }

    /**
     * Create an instance of {@link EpayUserLoginResponse }
     * 
     */
    public EpayUserLoginResponse createEpayUserLoginResponse() {
        return new EpayUserLoginResponse();
    }

    /**
     * Create an instance of {@link EpayUserLogout }
     * 
     */
    public EpayUserLogout createEpayUserLogout() {
        return new EpayUserLogout();
    }

    /**
     * Create an instance of {@link EpayUserLogoutResponse }
     * 
     */
    public EpayUserLogoutResponse createEpayUserLogoutResponse() {
        return new EpayUserLogoutResponse();
    }

    /**
     * Create an instance of {@link EpayLoadShoppingCart }
     * 
     */
    public EpayLoadShoppingCart createEpayLoadShoppingCart() {
        return new EpayLoadShoppingCart();
    }

    /**
     * Create an instance of {@link EpayLoadShoppingCartResponse }
     * 
     */
    public EpayLoadShoppingCartResponse createEpayLoadShoppingCartResponse() {
        return new EpayLoadShoppingCartResponse();
    }

    /**
     * Create an instance of {@link EpayGetStatus }
     * 
     */
    public EpayGetStatus createEpayGetStatus() {
        return new EpayGetStatus();
    }

    /**
     * Create an instance of {@link EpayGetStatusResponse }
     * 
     */
    public EpayGetStatusResponse createEpayGetStatusResponse() {
        return new EpayGetStatusResponse();
    }

    /**
     * Create an instance of {@link EpayGetStatusByVoucher }
     * 
     */
    public EpayGetStatusByVoucher createEpayGetStatusByVoucher() {
        return new EpayGetStatusByVoucher();
    }

    /**
     * Create an instance of {@link EpayGetStatusByVoucherResponse }
     * 
     */
    public EpayGetStatusByVoucherResponse createEpayGetStatusByVoucherResponse() {
        return new EpayGetStatusByVoucherResponse();
    }

    /**
     * Create an instance of {@link EpayUpdateVoucherStatus }
     * 
     */
    public EpayUpdateVoucherStatus createEpayUpdateVoucherStatus() {
        return new EpayUpdateVoucherStatus();
    }

    /**
     * Create an instance of {@link EpayUpdateVoucherStatusResponse }
     * 
     */
    public EpayUpdateVoucherStatusResponse createEpayUpdateVoucherStatusResponse() {
        return new EpayUpdateVoucherStatusResponse();
    }

    /**
     * Create an instance of {@link EpayLoadBilledFees }
     * 
     */
    public EpayLoadBilledFees createEpayLoadBilledFees() {
        return new EpayLoadBilledFees();
    }

    /**
     * Create an instance of {@link EpayLoadBilledFeesResponse }
     * 
     */
    public EpayLoadBilledFeesResponse createEpayLoadBilledFeesResponse() {
        return new EpayLoadBilledFeesResponse();
    }

    /**
     * Create an instance of {@link EpayGetPayments }
     * 
     */
    public EpayGetPayments createEpayGetPayments() {
        return new EpayGetPayments();
    }

    /**
     * Create an instance of {@link EpayGetPaymentsResponse }
     * 
     */
    public EpayGetPaymentsResponse createEpayGetPaymentsResponse() {
        return new EpayGetPaymentsResponse();
    }

    /**
     * Create an instance of {@link EpayError }
     * 
     */
    public EpayError createEpayError() {
        return new EpayError();
    }

    /**
     * Create an instance of {@link ErrorDetail }
     * 
     */
    public ErrorDetail createErrorDetail() {
        return new ErrorDetail();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link HeaderResponse }
     * 
     */
    public HeaderResponse createHeaderResponse() {
        return new HeaderResponse();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link EpaySessionInfo }
     * 
     */
    public EpaySessionInfo createEpaySessionInfo() {
        return new EpaySessionInfo();
    }

    /**
     * Create an instance of {@link ShoppingCartInfoArray }
     * 
     */
    public ShoppingCartInfoArray createShoppingCartInfoArray() {
        return new ShoppingCartInfoArray();
    }

    /**
     * Create an instance of {@link ShoppingCartInfo }
     * 
     */
    public ShoppingCartInfo createShoppingCartInfo() {
        return new ShoppingCartInfo();
    }

    /**
     * Create an instance of {@link GetStatusInfoArray }
     * 
     */
    public GetStatusInfoArray createGetStatusInfoArray() {
        return new GetStatusInfoArray();
    }

    /**
     * Create an instance of {@link GetStatusInfo }
     * 
     */
    public GetStatusInfo createGetStatusInfo() {
        return new GetStatusInfo();
    }

    /**
     * Create an instance of {@link GetStatusResponseInfoArray }
     * 
     */
    public GetStatusResponseInfoArray createGetStatusResponseInfoArray() {
        return new GetStatusResponseInfoArray();
    }

    /**
     * Create an instance of {@link VoucherArray }
     * 
     */
    public VoucherArray createVoucherArray() {
        return new VoucherArray();
    }

    /**
     * Create an instance of {@link ArNumArray }
     * 
     */
    public ArNumArray createArNumArray() {
        return new ArNumArray();
    }

    /**
     * Create an instance of {@link GetStatusResponseInfo }
     * 
     */
    public GetStatusResponseInfo createGetStatusResponseInfo() {
        return new GetStatusResponseInfo();
    }

    /**
     * Create an instance of {@link GetStatusByVoucherResponseInfoArray }
     * 
     */
    public GetStatusByVoucherResponseInfoArray createGetStatusByVoucherResponseInfoArray() {
        return new GetStatusByVoucherResponseInfoArray();
    }

    /**
     * Create an instance of {@link GetStatusByVoucherResponseInfo }
     * 
     */
    public GetStatusByVoucherResponseInfo createGetStatusByVoucherResponseInfo() {
        return new GetStatusByVoucherResponseInfo();
    }

    /**
     * Create an instance of {@link UpdateVoucherStatusInputArray }
     * 
     */
    public UpdateVoucherStatusInputArray createUpdateVoucherStatusInputArray() {
        return new UpdateVoucherStatusInputArray();
    }

    /**
     * Create an instance of {@link UpdateVoucherStatusInfo }
     * 
     */
    public UpdateVoucherStatusInfo createUpdateVoucherStatusInfo() {
        return new UpdateVoucherStatusInfo();
    }

    /**
     * Create an instance of {@link UpdateVoucherStatusOutputArray }
     * 
     */
    public UpdateVoucherStatusOutputArray createUpdateVoucherStatusOutputArray() {
        return new UpdateVoucherStatusOutputArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayPing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayPing")
    public JAXBElement<EpayPing> createEpayPing(EpayPing value) {
        return new JAXBElement<EpayPing>(_EpayPing_QNAME, EpayPing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayPingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayPingResponse")
    public JAXBElement<EpayPingResponse> createEpayPingResponse(EpayPingResponse value) {
        return new JAXBElement<EpayPingResponse>(_EpayPingResponse_QNAME, EpayPingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayUserLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayUserLogin")
    public JAXBElement<EpayUserLogin> createEpayUserLogin(EpayUserLogin value) {
        return new JAXBElement<EpayUserLogin>(_EpayUserLogin_QNAME, EpayUserLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayUserLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayUserLoginResponse")
    public JAXBElement<EpayUserLoginResponse> createEpayUserLoginResponse(EpayUserLoginResponse value) {
        return new JAXBElement<EpayUserLoginResponse>(_EpayUserLoginResponse_QNAME, EpayUserLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayUserLogout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayUserLogout")
    public JAXBElement<EpayUserLogout> createEpayUserLogout(EpayUserLogout value) {
        return new JAXBElement<EpayUserLogout>(_EpayUserLogout_QNAME, EpayUserLogout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayUserLogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayUserLogoutResponse")
    public JAXBElement<EpayUserLogoutResponse> createEpayUserLogoutResponse(EpayUserLogoutResponse value) {
        return new JAXBElement<EpayUserLogoutResponse>(_EpayUserLogoutResponse_QNAME, EpayUserLogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayLoadShoppingCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayLoadShoppingCart")
    public JAXBElement<EpayLoadShoppingCart> createEpayLoadShoppingCart(EpayLoadShoppingCart value) {
        return new JAXBElement<EpayLoadShoppingCart>(_EpayLoadShoppingCart_QNAME, EpayLoadShoppingCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayLoadShoppingCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayLoadShoppingCartResponse")
    public JAXBElement<EpayLoadShoppingCartResponse> createEpayLoadShoppingCartResponse(EpayLoadShoppingCartResponse value) {
        return new JAXBElement<EpayLoadShoppingCartResponse>(_EpayLoadShoppingCartResponse_QNAME, EpayLoadShoppingCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayGetStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayGetStatus")
    public JAXBElement<EpayGetStatus> createEpayGetStatus(EpayGetStatus value) {
        return new JAXBElement<EpayGetStatus>(_EpayGetStatus_QNAME, EpayGetStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayGetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayGetStatusResponse")
    public JAXBElement<EpayGetStatusResponse> createEpayGetStatusResponse(EpayGetStatusResponse value) {
        return new JAXBElement<EpayGetStatusResponse>(_EpayGetStatusResponse_QNAME, EpayGetStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayGetStatusByVoucher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayGetStatusByVoucher")
    public JAXBElement<EpayGetStatusByVoucher> createEpayGetStatusByVoucher(EpayGetStatusByVoucher value) {
        return new JAXBElement<EpayGetStatusByVoucher>(_EpayGetStatusByVoucher_QNAME, EpayGetStatusByVoucher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayGetStatusByVoucherResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayGetStatusByVoucherResponse")
    public JAXBElement<EpayGetStatusByVoucherResponse> createEpayGetStatusByVoucherResponse(EpayGetStatusByVoucherResponse value) {
        return new JAXBElement<EpayGetStatusByVoucherResponse>(_EpayGetStatusByVoucherResponse_QNAME, EpayGetStatusByVoucherResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayUpdateVoucherStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayUpdateVoucherStatus")
    public JAXBElement<EpayUpdateVoucherStatus> createEpayUpdateVoucherStatus(EpayUpdateVoucherStatus value) {
        return new JAXBElement<EpayUpdateVoucherStatus>(_EpayUpdateVoucherStatus_QNAME, EpayUpdateVoucherStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayUpdateVoucherStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayUpdateVoucherStatusResponse")
    public JAXBElement<EpayUpdateVoucherStatusResponse> createEpayUpdateVoucherStatusResponse(EpayUpdateVoucherStatusResponse value) {
        return new JAXBElement<EpayUpdateVoucherStatusResponse>(_EpayUpdateVoucherStatusResponse_QNAME, EpayUpdateVoucherStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayLoadBilledFees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayLoadBilledFees")
    public JAXBElement<EpayLoadBilledFees> createEpayLoadBilledFees(EpayLoadBilledFees value) {
        return new JAXBElement<EpayLoadBilledFees>(_EpayLoadBilledFees_QNAME, EpayLoadBilledFees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayLoadBilledFeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayLoadBilledFeesResponse")
    public JAXBElement<EpayLoadBilledFeesResponse> createEpayLoadBilledFeesResponse(EpayLoadBilledFeesResponse value) {
        return new JAXBElement<EpayLoadBilledFeesResponse>(_EpayLoadBilledFeesResponse_QNAME, EpayLoadBilledFeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayGetPayments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayGetPayments")
    public JAXBElement<EpayGetPayments> createEpayGetPayments(EpayGetPayments value) {
        return new JAXBElement<EpayGetPayments>(_EpayGetPayments_QNAME, EpayGetPayments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayGetPaymentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "EpayGetPaymentsResponse")
    public JAXBElement<EpayGetPaymentsResponse> createEpayGetPaymentsResponse(EpayGetPaymentsResponse value) {
        return new JAXBElement<EpayGetPaymentsResponse>(_EpayGetPaymentsResponse_QNAME, EpayGetPaymentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpayError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.epay.tceq.gov/xsd", name = "ErrorResponse")
    public JAXBElement<EpayError> createErrorResponse(EpayError value) {
        return new JAXBElement<EpayError>(_ErrorResponse_QNAME, EpayError.class, null, value);
    }

}

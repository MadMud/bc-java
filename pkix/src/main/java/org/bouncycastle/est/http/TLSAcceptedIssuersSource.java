package org.bouncycastle.est.http;

import java.security.cert.X509Certificate;

/**
 * TLSAcceptedIssuersSource provides an array of X509Certificates that
 * are to be accepted as issuers.
 */
public interface TLSAcceptedIssuersSource
{
    X509Certificate[] anchors();
}
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Stream that outputs encoding based on distinguished encoding rules.
 * 
 * @deprecated Will be removed from public API.
 */
public class DEROutputStream
    extends ASN1OutputStream
{
    /**
     * @deprecated Use {@link ASN1OutputStream#create(OutputStream, String)} with
     *             {@link ASN1Encoding#DER} instead.
     */
    public DEROutputStream(OutputStream os)
    {
        super(os);
    }

    public void writeObject(ASN1Encodable obj) throws IOException
    {
        if (obj != null)
        {
            obj.toASN1Primitive().toDERObject().encode(this, true);
        }
        else
        {
            throw new IOException("null object detected");
        }
    }

    public void writeObject(ASN1Primitive primitive) throws IOException
    {
        if (null == primitive)
        {
            throw new IOException("null object detected");
        }

        primitive.toDERObject().encode(this, true);
    }

    void writePrimitive(ASN1Primitive primitive, boolean withTag) throws IOException
    {
        primitive.toDERObject().encode(this, withTag);
    }

    DEROutputStream getDERSubStream()
    {
        return this;
    }

    ASN1OutputStream getDLSubStream()
    {
        return this;
    }
}

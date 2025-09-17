package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String text, int width, int height) {
        try {
            // 1. Create a QRCodeWriter object (from the ZXing library).
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // 2. "Encode" the text (UPI link) into a BitMatrix.
            //    A BitMatrix is like a grid of black and white squares that represents the QR code.
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            // 3. Convert the BitMatrix into an image (PNG format).
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

            // 4. Return the image as a byte array.
            return pngOutputStream.toByteArray();

        } catch (Exception e) {
            // Handle the error (in a real app, you'd log this)
            return new byte[0]; // Return an empty array for now
        }
    }
}
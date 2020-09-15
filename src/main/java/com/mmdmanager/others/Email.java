package com.mmdmanager.others;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Email {
    MultiPartEmail email = new MultiPartEmail();
    EmailAttachment attachment = new EmailAttachment();

    public MultiPartEmail sendEmailWithAttachment(ResultSet resultSet, int materialsQuantity) throws SQLException {

        try {
            if (resultSet.next()) {
                int request_no = resultSet.getInt(2);
                String attachmentPath = "C:\\Users\\admin\\Desktop\\Request " + String.valueOf(request_no) + ".xlsx";

                attachment.setPath(attachmentPath);
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("Excel");

                email.setHostName("smtp.poczta.onet.pl");
                email.setSmtpPort(465);
                email.setAuthentication("domanski.adam_wojciech@poczta.onet.pl","Q@3wertyuiop");
                email.setSSLOnConnect(true);
                email.setFrom("domanski.adam_wojciech@poczta.onet.pl");
                email.setSubject("Request Number: " + request_no + " | Material Creation");
                email.setMsg("Dear Team,\n" +
                        "\n" +
                        "the email attached contains " + materialsQuantity + " materials to be created.\n" +
                        "In case of questions, please let me know.\n" +
                        "\n" +
                        "Kind Regards");
                email.addTo("domanski.adam_wojciech@poczta.onet.pl");
                email.attach(attachment);
                email.send();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return email;
    }
}

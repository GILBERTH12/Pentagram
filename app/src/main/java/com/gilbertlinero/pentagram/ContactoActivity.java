package com.gilbertlinero.pentagram;

import android.os.AsyncTask;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ContactoActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtEmail;
    EditText txtMensaje;
    Button btnEnviarComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

            android.support.v7.widget.Toolbar miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        TextView mTitle = (TextView) miActionBar.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.menu_contacto));
    }

    public void enviarComentario(View v) {

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        txtEmail = (EditText) findViewById(R.id.txtEmail);

        String[] recipients = { txtEmail.getText().toString() };
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.correo = "correopruebaa22@gmail.com";
        email.contrasena = "pruebaa22";
        email.from = "correopruebaa22@gmail.com";
        email.body = txtMensaje.getText().toString();
        email.to = recipients;
        email.subject = txtNombre.getText().toString();
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.btnEnviarComentario), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
    String correo;
    String contrasena;
    String from;
    String body;
    String[] to;
    String subject;
    private Multipart multipart = new MimeMultipart();

    ContactoActivity activity;

    public SendEmailAsyncTask() {}

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            if (send()) {
                activity.displayMessage("Comentario enviado.");
            } else {
                activity.displayMessage("Fallido envio de comentario.");
            }

            return true;
        } catch (AuthenticationFailedException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Datos de la cuenta erroneos");
            e.printStackTrace();
            activity.displayMessage("Autenticacion fallida.");
            return false;
        } catch (MessagingException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Fallido envio de comentario");
            e.printStackTrace();
            activity.displayMessage("Fallido envio de comentario.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            activity.displayMessage("Inesperado error ocurrido.");
            return false;
        }
    }

    public boolean send() throws Exception {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.debug", "true");

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        if (!correo.equals("") && !contrasena.equals("") && to.length > 0
                && !from.equals("") && !subject.equals("")
                && !body.equals("")) {
            Session session = Session.getInstance(props, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(correo, contrasena);
                }
            });

            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));

            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }
            msg.setRecipients(MimeMessage.RecipientType.TO, addressTo);

            msg.setSubject(subject);
            msg.setSentDate(new Date());

            // setup message body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            multipart.addBodyPart(messageBodyPart);

            msg.setHeader("X-Priority", "1");
            // Put parts in message
            msg.setContent(multipart);

            // send email
            Transport.send(msg);

            return true;
        } else {
            return false;
        }
    }
}



package Mail;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;



	 
	 
	public class SMTPAuthenticatior extends Authenticator{
	 String id ,pass;
	 
	    public SMTPAuthenticatior(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

		@Override
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(id,pass);
	    }
	}



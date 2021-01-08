import './styles.css';
import {ReactComponent as LinkedInIcon} from './Linkedin.svg';

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.linkedin.com/in/leofabiano/" target="_new">
                    <LinkedInIcon />
                </a>
            </div>
        </footer>
    )
};

export default Footer;
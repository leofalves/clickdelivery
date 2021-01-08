import './styles.css';
import {ReactComponent as MainImage} from './main.svg';

function Home() {
    return (
        <div className="home-container">
            <div className="home-content">
                <div className="home-actions">
                    <div className="home-title">
                        <h1>Faça seu pedido<br/>que entregamos<br/>para você!</h1>
                    </div>
                    <div className="home-subtitle">
                        <h3>Entregamos com todos os cuidados que você merece<br/>Nossos entregadores usam máscara 100% do tempo</h3>
                    </div>
                    <a href="orders" className="home-btn-order">
                        FAZER PEDIDO
                    </a>
                </div>
                <div className="home-image">
                    <MainImage />
                </div>
            </div>
        </div>
    )
};

export default Home;
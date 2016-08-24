package com.herokuapp.ggrosario.servlet.init;

import com.herokuapp.ggrosario.exepciones.CatalogoException;
import com.herokuapp.ggrosario.exepciones.JuegoException;
import com.herokuapp.ggrosario.exepciones.RolException;
import com.herokuapp.ggrosario.exepciones.UsuarioException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.herokuapp.ggrosario.modelo.Configuracion;
import com.herokuapp.ggrosario.modelo.Juego;
import com.herokuapp.ggrosario.modelo.Permisos;
import com.herokuapp.ggrosario.modelo.Requisito;
import com.herokuapp.ggrosario.modelo.RequisitoMinimo;
import com.herokuapp.ggrosario.modelo.RequisitoRecomendado;
import com.herokuapp.ggrosario.modelo.Rol;
import com.herokuapp.ggrosario.modelo.Tienda;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "InitServlet", urlPatterns = {"/init"})
public class InitServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Configuracion unaConfiguracion = new Configuracion(5, 10, true, false);
        Tienda unaTienda = new Tienda("GG Rosario", unaConfiguracion);
        Rol unRol;

        try {
            unaTienda.addRol("Administrador");
            unRol = unaTienda.getRol("Administrador");
            Permisos permisosAdministrador = new Permisos();
            permisosAdministrador.setCanDoAll(true);
            unRol.setPermisos(permisosAdministrador);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addRol("Empleado");
            unRol = unaTienda.getRol("Empleado");
            Permisos permisosEmpleados = new Permisos();
            permisosEmpleados.setPermisosEmpleado();
            unRol.setPermisos(permisosEmpleados);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addRol("Cliente");
            unRol = unaTienda.getRol("Cliente");
            Permisos permisosClientes = new Permisos();
            permisosClientes.setPermisosCliente();
            unRol.setPermisos(permisosClientes);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addCatalogo("Catálogo de " + unaTienda.getNombre());
        } catch (CatalogoException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addUsuario("default@ggrosario.com", "default", "default", new Date("02/03/1994"), "Administrador", "Default", "0800-default", unaTienda.getRol("Administrador"));

        } catch (UsuarioException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addJuego("F1 - 2016", "Crea tu propia leyenda en F1™ 2016. Prepárate para sumergirte de una forma más intensa que nunca en el mundo del deporte automovilístico más prestigioso. F1 2016 es el videojuego oficial del CAMPEONATO MUNDIAL DE FÓRMULA UNO DE LA FIA 2016™ que presenta los 21 circuitos que recoge el calendario de la temporada de 2016, como el circuito nuevo de Bakú en Azerbaiyán y la plantilla completa de 22 pilotos y 11 equipos, lo que incluye el nuevo equipo Haas F1 Team. F1 2016 no solo te sumerge en la diversión de una carrera de FÓRMULA UNO™, con el simbólico coche de seguridad y con el coche de seguridad virtual como novedad, sino que también ofrece exclusivamente todo el drama y el desarrollo del vehículo que se esconde detrás de las cámaras. Trabaja con tu agente, ingeniero y equipo para desarrollar tu monoplaza en la experiencia de carrera profesional más intensa en diez temporadas. Forja tu propio camino a la gloria y álzate para convertirte en el campeón.", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471671688/kxloejlvrubty5bmq0qo.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("GTA V", "Grand Theft Auto V aprovechará al máximo la potencia del PC para ofrecer mejoras de todo tipo, que incluyen resolución y detalle gráfico incrementados, tráfico más denso, mayor distancia visual, IA mejorada, nueva fauna y avanzados efectos de clima y daño, para crear la experiencia de mundo abierto definitiva.\n"
                    + "\n"
                    + "Los Santos, una extensa y soleada metrópolis llena de gurús de autoayuda, aspirantes a estrellas y famosos en decadencia, en su día la envidia del mundo occidental, lucha ahora por mantenerse a flote en una era de incertidumbre económica y \"realities\" baratos. En medio de la confusión, tres criminales muy diferentes lo arriesgarán todo en una serie de atrevidos y peligrosos atracos que marcarán sus vidas.\n"
                    + "\n"
                    + "El mundo abierto más grande, más dinámico y más diverso jamás creado, ahora con un montón de detalles nuevos. Grand Theft Auto V combina historia y jugabilidad de una nueva forma. Los jugadores entran y salen repetidamente de las vidas de los tres personajes principales, participando en todos los aspectos de la historia entrelazada del juego.\n"
                    + "\n"
                    + "Grand Theft Auto V para PC también incluye Grand Theft Auto Online, el universo de Grand Theft Auto en continua evolución. Explora el extenso mundo o asciende en el escalafón criminal formando equipo para completar actividades y ganar dinero; comprar propiedades, mejoras de personajes y vehículos; competir en modos competitivos tradicionales o crear nuevo contenido para jugar y compartir con la comunidad de Grand Theft Auto.\n"
                    + "\n"
                    + "Todo el nuevo contenido creado y publicado desde el lanzamiento de Grand Theft Auto Online, incluyendo nuevas actividades, un arsenal de armas nuevas, montones de nuevos vehículos, nuevas propiedades y personalizaciones de los jugadores, también estará disponible en Grand Theft Auto Online para PC. Además, la comunidad actual de jugadores tendrá la posibilidad de transferir sus personajes y progreso en Grand Theft Auto Online a PlayStation®4, Xbox One o PC, a su elección.\n"
                    + "\n"
                    + "Grand Theft Auto V para PC también dispondrá de un editor de vídeo diseñado para la creación avanzada de películas.", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471806142/qrzeksimej9uol0lsajj.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("No Man's Sky", "Inspired by the adventure and imagination that we love from classic science-fiction, No Man's Sky presents you with a galaxy to explore, filled with unique planets and lifeforms, and constant danger and action.\n"
                    + "\n"
                    + "In No Man's Sky, every star is the light of a distant sun, each orbited by planets filled with life, and you can go to any of them you choose. Fly smoothly from deep space to planetary surfaces, with no loading screens, and no limits. In this infinite procedurally generated universe, you'll discover places and creatures that no other players have seen before - and perhaps never will again.At the centre of the galaxy lies a irresistible pulse which draws you on a journey towards it to learn the true nature of the cosmos. But, facing hostile creatures and fierce pirates, you'll know that death comes at a cost, and survival will be down to the choices you make over how you upgrade your ship, your weapon and suit.Your voyage through No Man's Sky is up to you. Will you be a fighter, preying on the weak and taking their riches, or taking out pirates for their bounties? Power is yours if you upgrade your ship for speed and weaponry.\n"
                    + "\n"
                    + "Or a trader? Find rich resources on forgotten worlds and exploit them for the highest prices. Invest in more cargo space and you'll reap huge rewards.\n"
                    + "\n"
                    + "Or perhaps an explorer? Go beyond the known frontier and discover places and things that no one has ever seen before. Upgrade your engines to jump ever farther, and strengthen your suit for survival in toxic environments that would kill the unwary.The galaxy is a living, breathing place. Trade convoys travel between stars, factions vie for territory, pirates hunt the unwary, and the police are ever watching. Every other player lives in the same galaxy, and you can choose to share your discoveries with them on a map that spans known space. Perhaps you will see the results of their actions as well as your own...", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471671724/b60vehbpz6xsasguyru3.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("Life is strange", "Life Is Strange es un título de cinco episodios que se propone revolucionar los juegos de elecciones y consecuencias basados en la historia al permitir a los jugadores retroceder en el tiempo para cambiar el pasado, el presente y el futuro.\n"
                    + "\n"
                    + "Juegas en el papel de Max, una estudiante de fotografía que consigue salvarle la vida a su amiga Chloe cuando descubre que es capaz de retroceder en el tiempo. Pronto ambas conocerán el lado más oscuro de la ciudad de Arcadia Bay, a medida que descubren la cruda verdad sobre la repentina desaparición de otra estudiante.\n"
                    + "\n"
                    + "Mientras tanto, Max comienza a tener premoniciones, que se suman a sus dificultades para entender lo que implica su poder. Debe aprender cuanto antes que cambiar el pasado a veces puede traer consecuencias desastrosas en el futuro.\n"
                    + "\n"
                    + "    * Un juego de aventuras moderno con una narrativa excelente.\n"
                    + "    * Retrocede en el tiempo para cambiar el curso de los acontecimientos.\n"
                    + "    * Varios finales posibles que dependen de las decisiones que tomes.\n"
                    + "    * Gráficos sorprendentes dibujados a mano.\n"
                    + "    * Una banda sonora con música indie.", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471653826/lnr0gnqywhaygz7o0wn7.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("TWD - Season 1", "Obtenga acceso a la temporada completa [5] episodios de The Walking Dead por la compra del pase de temporada, que actuará como su puerta de entrada a todos los episodios del juego. Los cinco episodios ya están disponibles inmediatamente después de la compra de la temporada completa.\n"
                    + "The Walking Dead es un juego de la serie de cinco capítulos ambientada en el mismo universo que la galardonada serie de cómics de Robert Kirkman. Juega como Lee Everett, un criminal condenado, que se le ha dado una segunda oportunidad en la vida en un mundo devastado por los muertos vivientes. Con cadáveres que vuelven a la vida y los sobrevivientes que paran ante nada para mantener su propia seguridad, la protección de una niña huérfana llamada Clementine le pueden ofrecer la redención en un mundo perdido.", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471672925/qjmbkzoyx9osimcal8is.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("TWD - Season 2", "The Walking Dead: Season Two continues the story of Clementine, a young girl orphaned by the undead apocalypse. Left to fend for herself, she has been forced to learn how to survive in a world gone mad.\n"
                    + "\n"
                    + "Many months have passed since the events seen in Season One of The Walking Dead, and Clementine is searching for safety. But what can an ordinary child do to stay alive when the living can be just as bad – and sometimes worse – than the dead? As Clementine, you will be tested by situations and dilemmas that will test your morals and your instinct for survival. Your decisions and actions will change the story around you, in this sequel to 2012’s Game of the Year.\n"
                    + "\n"
                    + "The Season Pass gives you access to all five critically acclaimed episodes:\n"
                    + "\n"
                    + "Episode 1: All That Remains\n"
                    + "Episode 2: A House Divided\n"
                    + "Episode 3: In Harm’s Way\n"
                    + "Episode 4: Amid the Ruins\n"
                    + "Episode 5: No Going Back\n"
                    + "\n"
                    + "    Decisions you made in Season One and in 400 Days will affect your story in Season Two\n"
                    + "    Based on Robert Kirkman’s award-winning comic books\n"
                    + "    Play as Clementine, an orphaned girl forced to grow up fast by the world around her\n"
                    + "    The sequel to 2012’s Game of the Year", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471673327/rxooukv6569bgyutgmtq.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("Minecraft Story mode", "In this five part episodic series, you’ll embark on a perilous adventure across the Overworld, through the Nether, to the End, and beyond. You and your friends revere the legendary Order of the Stone: Warrior, Redstone Engineer, Griefer, and Architect; slayers of the Ender Dragon. While at EnderCon in hopes of meeting Gabriel the Warrior, you and your friends discover that something is wrong… something dreadful. Terror is unleashed, and you must set out on a quest to find The Order of the Stone if you are to save your world from oblivion.\n"
                    + "\n"
                    + "• Created by award-winning adventure game powerhouse Telltale Games, in partnership with Minecraft creators, Mojang\n"
                    + "\n"
                    + "• Featuring the voices of Patton Oswalt (Ratatouille, Agents of S.H.I.E.L.D), Brian Posehn (The Sarah Silverman Program, Mission Hill), Ashley Johnson (The Last of Us, Tales from the Borderlands), Scott Porter (Friday Night Lights, X-Men), Martha Plimpton (The Goonies, Raising Hope), Dave Fennoy (The Walking Dead: A Telltale Games Series, Batman: Arkham Knight), Corey Feldman (The Goonies, Stand by Me), Billy West (Futurama, Adventure Time), and Paul Reubens (Tron: Uprising, Pee-Wee’s Playhouse)\n"
                    + "\n"
                    + "• You will drive the story through the decisions you make: what you say to people (and how you say it), and what you choose to do in moments of thrilling action will make this YOUR story", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471669709/py3dtjdeogwur8oyhhku.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("Minecraft", "Minecraft es un juego de romper y la colocación de los bloques. Al principio, la gente construyó las estructuras para proteger contra monstruos nocturnos, pero como el juego creció jugadores trabajaron juntos para crear cosas maravillosas e imaginativas.\n"
                    + "También puede tratarse de aventuras con amigos o viendo la salida del sol sobre un océano en bloques. Es bastante. Jugadores valientes luchan cosas terribles en los Países, que es más aterrador que bastante. También se puede visitar una tierra de setas si suena más como su taza de té.", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471653658/vxlkg6gqeoojkczcymxu.jpg", unaTienda.getCatalogos().get(0), null, null);
            unaTienda.addJuego("Overwatch", "Soldados. Científicos. Aventureros. Prodigios.\n"
                    + "En una época de crisis global, un escuadrón internacional de héroes se formó para devolver la paz a un mundo devastado por la guerra: OVERWATCH.\n"
                    + "\n"
                    + "Juntos pusieron fin a la crisis y mantuvieron la paz en las décadas posteriores, dando pie a toda una era de exploración, innovación y descubrimiento. Sin embargo, muchos años después, la influencia de Overwatch disminuyó y esta acabó por disolverse. Overwatch ya no existe... pero el mundo aún necesita héroes.\n"
                    + "\n"
                    + "Overwatch es un shooter por equipos en el que varios héroes luchan en un mundo lleno de conflictos.", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471673661/qfqsk4wuu7lvndo1wlbj.jpg", unaTienda.getCatalogos().get(0), null, null);
            List<Requisito> requisitosMinimos = new ArrayList<>();
            List<Requisito> requisitosRecomendados = new ArrayList<>();
            requisitosMinimos.add(new RequisitoMinimo("Win 7 64", "Core i3-530 2.9GHz / FX-4100", "8 GB", "GeForce GTX 460 / Radeon HD 5870 1024MB", "30 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 7 64", "Core i5-4690 3.5GHz / FX-8320", "8 GB", "GeForce GTX 980 4GB / Radeon R9 FURY 4GB", "30 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win 7 64", "Core 2 Quad Q6600 2.4GHz / Phenom 9850 Quad-Core Black Edition", "4 GB", "GeForce 9800 GT / Radeon HD 4870", "65 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 8 64", "Core i5-3470 3.2GHz / FX-8350", "8 GB", "GeForce GTX 660 / Radeon HD 7870", "65 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win 7 64", "Core i3-530 2.9GHz / Athlon X4 730", "8 GB", "GeForce GTX 480 / Radeon HD 6970", "10 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 7 64", "Core i7-860 Quad 2.80GHz / FX-8120", "8 GB", "GeForce GTX 960 2GB / Radeon R9 285 2GB", "10 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win Vista 32", "Core 2 Duo E4400 2.0GHz / Athlon 64 X2 Dual Core 3800+", "2 GB", "GeForce 315 512MB / Radeon HD 5450 512MB", "3 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 7 32", "Core 2 Duo E8400 3.0GHz / Athlon 64 X2 Dual Core 6000+", "2 GB", "GeForce GTX 260 / Radeon HD 4890", "3 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win Xp 32", "Pentium 4 2.0GHz / Athlon XP 1700+", "3 GB", "GeForce 205 / Radeon HD 6290", "2 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win Xp 32", "Core 2 Duo E4600 2.4GHz / Athlon 5050e Dual Core", "3 GB", "GeForce GT 130 / Radeon HD 4650 1GB", "2 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win XP", "Core 2 Duo 2GHz or equivalent", "3 GB", "ATI or Nvidia card w/ 512 MB RAM ", "2 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 7", "Core 2 Duo 2.3GHz or equivalent", "4 GB", "ATI or Nvidia card w/ 1024 MB RAM", "2 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win Xp 32", "Core 2 Duo E4600 2.4GHz / Athlon 64 X2 Dual Core 5000+", "3 GB", "GeForce GT 720 / Radeon HD 3800 series", "3 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 7 32", "Core i3-3240 3.4GHz / Phenom II X4 40", "4 GB", "GeForce GT 640 v3 / Radeon R7 250 v2 2GB", "3 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win Xp 32", "Pentium 4 1.6GHz / Athlon XP 1600+", "500 MB", "GeForce 4 MX 440 / Radeon HD 3200", "1 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win Xp 32", "Pentium 4 3.0GHz / Athlon XP 2600+", "1 GB", "GeForce 8600 GS / Radeon HD 6320", "1 GB"));
            requisitosMinimos.add(new RequisitoMinimo("Win 7 64", "Core i3-540 3.06GHz / Phenom II X3 720", "4 GB", "GeForce GTX 460 / Radeon HD 4850", "5 GB"));
            requisitosRecomendados.add(new RequisitoRecomendado("Win 7 64", "Core i5-670 3.46GHz / Phenom II X4 900e", "6 GB", "GeForce GTX 660 / Radeon HD 7950", "5 GB"));
            int i = 0;
            for (Juego j : unaTienda.getJuegos()) {
                j.setRequisitosMinimos(requisitosMinimos.get(i));
                i++;
            }

            i = 0;
            for (Juego j : unaTienda.getJuegos()) {
                j.setRequisitosRecomendados(requisitosRecomendados.get(i));
                i++;
            }

        } catch (JuegoException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getSession().setAttribute("unaTienda", unaTienda);
        response.sendRedirect("index");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para inicializar el sistema por única vez";
    }// </editor-fold>

}

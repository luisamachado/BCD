from dominate.tags import a
from flask import Flask, render_template, session, url_for, redirect, flash, request
from flask_bootstrap import Bootstrap
from flask_nav import Nav
from flask_nav.elements import Navbar, View, Subgroup, Link
from flask_sqlalchemy import SQLAlchemy, xrange
from flask_wtf import FlaskForm
from sqlalchemy import ForeignKey
from sqlalchemy.orm import relationship
from sqlalchemy.testing import db
from werkzeug.security import generate_password_hash, check_password_hash
from wtforms import StringField, SubmitField
from wtforms import PasswordField
from wtforms.validators import DataRequired
from meusforms import LoginForm, FormDeRegistro, FormDisc, FormAssunto, FormPerg, FormDiscursiva, FormAlternativa, \
    FormProva, FormAssuntos

SECRET_KEY = 'banco_projeto2'
app = Flask(__name__)
app.secret_key = SECRET_KEY

bootstrap = Bootstrap(app)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///projeto2.sqlite'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

nav = Nav()
nav.init_app(app) # menu no topo da página

@nav.navigation()
def meunavbar():
    menu = Navbar('Menu')
    menu.items = [View('Home', 'inicio'), View('Login', 'autenticar')]
    menu.items.append(View('Cadastro', 'cadastro'))
    if ('logged_in' in session) and session['logged_in']:
        menu.items.append(Subgroup('Disciplinas', View('Inserir', 'insereDisc'), View('Listar', 'listaDisc')))
        menu.items.append(View('Gerar prova', 'geraProva'))
        if request.endpoint == 'listaAssunto':
            menu.items.append(Subgroup('Assuntos', View('Inserir', 'insereAssunto')))
    menu.items.append(View('Logout', 'sair'))
    return menu

# from app import db, Professor, Disciplina, Assunto, Pergunta, Resposta, Prova, Historico
# db.create_all()

class Professor(db.Model):
    __tablename__ = "Professor"
    idProfessor = db.Column(db.Integer, primary_key=True)
    usuario = db.Column(db.String(40), index=True, unique=True)
    senha = db.Column(db.String(128))

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.usuario = kwargs.pop('usuario')
        self.senha = generate_password_hash(kwargs.pop('senha'))

    def set_password(self, password):
        self.senha = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.senha, password)

    def __repr__(self):
        return '<User {}>'.format(self.usuario)


class Disciplina(db.Model):
    __tablename__ = "Disciplina"
    idDisciplina = db.Column(db.Integer, primary_key=True)
    nome_disc = db.Column(db.String(40))
    idProfessor = db.Column(db.Integer, ForeignKey('Professor.idProfessor'))
    professor = relationship(Professor)

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.nome_disc = kwargs.pop('nome_disc')
        self.idProfessor = kwargs.pop('idProfessor')


class Prova(db.Model):
    __tablename__ = "Prova"
    idProva = db.Column(db.Integer, primary_key=True)
    ano = db.Column(db.Integer)
    semestre = db.Column(db.Integer)
    idDisciplina = db.Column(db.Integer, ForeignKey('Disciplina.idDisciplina'))
    disc = relationship(Disciplina)
    idProfessor = db.Column(db.Integer, ForeignKey('Professor.idProfessor'))
    professor = relationship(Professor)

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.ano = kwargs.pop('ano')
        self.semestre = kwargs.pop('semestre')
        self.idDisciplina = kwargs.pop('idDisciplina')
        self.idProfessor = kwargs.pop('idProfessor')


class Assunto(db.Model):
    __tablename__ = "Assunto"
    idAssunto = db.Column(db.Integer, primary_key=True)
    nome_assunto = db.Column(db.String(40))
    idDisciplina = db.Column(db.Integer, ForeignKey('Disciplina.idDisciplina'))
    disc = relationship(Disciplina)
    idProfessor = db.Column(db.Integer, ForeignKey('Professor.idProfessor'))
    professor = relationship(Professor)

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.nome_assunto = kwargs.pop('nome_assunto')
        self.idDisciplina = kwargs.pop('idDisciplina')
        self.idProfessor = kwargs.pop('idProfessor')


class Pergunta(db.Model):
    __tablename__ = "Pergunta"
    idPergunta = db.Column(db.Integer, primary_key=True)
    pergunta = db.Column(db.String(400))
    flag_alternativa = db.Column(db.Boolean, default="False")
    idAssunto = db.Column(db.Integer, ForeignKey('Assunto.idAssunto'))
    assunto = relationship(Assunto)
    idDisciplina = db.Column(db.Integer, ForeignKey('Disciplina.idDisciplina'))
    disc = relationship(Disciplina)
    idProfessor = db.Column(db.Integer, ForeignKey('Professor.idProfessor'))
    professor = relationship(Professor)

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.pergunta = kwargs.pop('pergunta')
        self.flag_alternativa = kwargs.pop('flag_alternativa')
        self.idAssunto = kwargs.pop('idAssunto')
        self.idDisciplina = kwargs.pop('idDisciplina')
        self.idProfessor = kwargs.pop('idProfessor')


class Resposta(db.Model):
    __tablename__ = "Resposta"
    idResposta = db.Column(db.Integer, primary_key=True)
    alternativa = db.Column(db.String(200))
    correta = db.Column(db.Boolean, default="True")
    idPergunta = db.Column(db.Integer, ForeignKey('Pergunta.idPergunta'))
    perg = relationship(Pergunta)
    idAssunto = db.Column(db.Integer, ForeignKey('Assunto.idAssunto'))
    assunto = relationship(Assunto)
    idDisciplina = db.Column(db.Integer, ForeignKey('Disciplina.idDisciplina'))
    disc = relationship(Disciplina)
    idProfessor = db.Column(db.Integer, ForeignKey('Professor.idProfessor'))
    professor = relationship(Professor)

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.alternativa = kwargs.pop('alternativa')
        self.correta = kwargs.pop('correta')
        self.idPergunta = kwargs.pop('idPergunta')
        self.idAssunto = kwargs.pop('idAssunto')
        self.idDisciplina = kwargs.pop('idDisciplina')
        self.idProfessor = kwargs.pop('idProfessor')


class Historico(db.Model):
    __tablename__ = "Historico"
    idHist  = db.Column(db.Integer, primary_key=True)
    idPergunta = db.Column(db.Integer, ForeignKey('Pergunta.idPergunta'))
    perg = relationship(Pergunta)
    idAssunto = db.Column(db.Integer, ForeignKey('Assunto.idAssunto'))
    assunto = relationship(Assunto)
    idDisciplina = db.Column(db.Integer, ForeignKey('Disciplina.idDisciplina'))
    disc = relationship(Disciplina)
    idProfessor = db.Column(db.Integer, ForeignKey('Professor.idProfessor'))
    professor = relationship(Professor)
    idProva = db.Column(db.Integer, ForeignKey('Prova.idProva'))
    prova = relationship(Prova)

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.idPergunta = kwargs.pop('idPergunta')
        self.idAssunto = kwargs.pop('idAssunto')
        self.idDisciplina = kwargs.pop('idDisciplina')
        self.idProfessor = kwargs.pop('idProfessor')
        self.idProva = kwargs.pop('idProva')


@app.route('/registro', methods=['GET', 'POST'])
def cadastro():
    formulario = FormDeRegistro()
    if formulario.validate_on_submit():
        novo = Professor(usuario=formulario.username.data, senha=formulario.password.data)
        db.session.add(novo)
        db.session.commit()
        return render_template('index.html', title='Início')
    return render_template('registro.html', title='Cadastro de usuário', form=formulario)


@app.route('/listar_disciplina', methods=['GET', 'POST'])
def listaDisc():
    if session.get('logged_in'):
        disc = Disciplina.query.filter_by(idProfessor=session['idProf']).all()
        print(disc)
        return render_template('listaDisc.html', title='Listar Disciplinas', disciplinas=disc)
    return redirect(url_for('inicio'))


@app.route('/insere_disciplina', methods=['GET', 'POST'])
def insereDisc():
    if session.get('logged_in'):
        formulario = FormDisc()
        if formulario.validate_on_submit():
            nova = Disciplina(nome_disc=formulario.nome.data, idProfessor=session['idProf'])
            db.session.add(nova)
            db.session.commit()
            return redirect(url_for('listaDisc'))
        return render_template('insereDisc.html', title='Cadastro de disciplina', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/listar_assunto', methods=['GET', 'POST'])
def listaAssunto():
    if session.get('logged_in'):
        idDisc = request.args['idDisciplina']
        nomeDisc = Disciplina.query.filter_by(idDisciplina=idDisc).first_or_404()
        ass = Assunto.query.filter_by(idDisciplina=idDisc).all()
        return render_template('listaAssunto.html', title='Listar Assuntos', assunto=ass, idDisciplina=idDisc, disciplina=nomeDisc)
    return redirect(url_for('inicio'))


@app.route('/insere_assunto', methods=['GET', 'POST'])
def insereAssunto():
    if session.get('logged_in'):
        formulario = FormAssunto()
        if formulario.validate_on_submit():
            print('insere')
            idDisc = request.args['idDisciplina']
            print(idDisc)
            nova = Assunto(nome_assunto=formulario.nome.data, idDisciplina=idDisc, idProfessor=session['idProf'])
            db.session.add(nova)
            db.session.commit()
            return redirect(url_for('listaAssunto', idDisciplina=idDisc))
        return render_template('insereAssunto.html', title='Cadastro de assunto', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/listar_pergunta', methods=['GET', 'POST'])
def listaPerg():
    if session.get('logged_in'):
        idAss = request.args['idAssunto']
        ass = Assunto.query.filter_by(idAssunto=idAss).first_or_404()
        perg = Pergunta.query.filter_by(idAssunto=idAss).all()
        return render_template('listaPerg.html', title='Listar Perguntas', pergunta=perg, assunto=ass)
    return redirect(url_for('inicio'))


@app.route('/insere_perg', methods=['GET', 'POST'])
def inserePerg():
    if session.get('logged_in'):
        formulario = FormPerg()
        if formulario.validate_on_submit():
            idAss = request.args['idAssunto']
            ass = Assunto.query.filter_by(idAssunto=idAss).first_or_404()
            if formulario.flag.data == '0':
                nova = Pergunta(pergunta=formulario.perg.data, idDisciplina=ass.idDisciplina, idProfessor=session['idProf'], idAssunto=idAss, flag_alternativa=False)
                db.session.add(nova)
                db.session.commit()
                perg = Pergunta.query.filter_by(pergunta=formulario.perg.data, idAssunto=idAss).first_or_404()
                session['idPerg'] = perg.idPergunta
                return redirect(url_for('insereDiscursiva'))
            else:
                nova = Pergunta(pergunta=formulario.perg.data, idDisciplina=ass.idDisciplina, idProfessor=session['idProf'], idAssunto=idAss, flag_alternativa=True)
                db.session.add(nova)
                db.session.commit()
                perg = Pergunta.query.filter_by(pergunta=formulario.perg.data, idAssunto=idAss).first_or_404()
                session['idPerg'] = perg.idPergunta
                return redirect(url_for('insereAlternativa'))
        return render_template('inserePerg.html', title='Cadastro de Pergunta', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/insere_discursiva', methods=['GET', 'POST'])
def insereDiscursiva():
    if session.get('logged_in'):
        formulario = FormDiscursiva()
        if formulario.validate_on_submit():
            perg = Pergunta.query.filter_by(idPergunta=session['idPerg']).first_or_404()
            idPerg = perg.idPergunta
            idDisc = perg.idDisciplina
            idAss = perg.idAssunto
            nova = Resposta(alternativa=formulario.resp.data, idDisciplina=idDisc, idProfessor=session['idProf'], idAssunto=idAss, idPergunta=idPerg, correta=True)
            db.session.add(nova)
            db.session.commit()
            session['idPerg'] = 0
            return redirect(url_for('listaPerg', idAssunto=idAss))
        return render_template('insereResposta.html', title='Cadastro de Resposta Discursiva', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/insere_alternativa', methods=['GET', 'POST'])
def insereAlternativa():
    if session.get('logged_in'):
        formulario = FormAlternativa()
        if formulario.validate_on_submit():
            perg = Pergunta.query.filter_by(idPergunta=session['idPerg']).first_or_404()
            idPerg = perg.idPergunta
            idDisc = perg.idDisciplina
            idAss = perg.idAssunto
            correta = Resposta(alternativa=formulario.correta.data, idDisciplina=idDisc, idProfessor=session['idProf'], idAssunto=idAss, idPergunta=idPerg, correta=True)
            db.session.add(correta)
            alt1 = Resposta(alternativa=formulario.alt1.data, idDisciplina=idDisc, idProfessor=session['idProf'], idAssunto=idAss, idPergunta=idPerg, correta=False)
            db.session.add(alt1)
            alt2 = Resposta(alternativa=formulario.alt2.data, idDisciplina=idDisc, idProfessor=session['idProf'], idAssunto=idAss, idPergunta=idPerg, correta=False)
            db.session.add(alt2)
            alt3 = Resposta(alternativa=formulario.alt3.data, idDisciplina=idDisc, idProfessor=session['idProf'], idAssunto=idAss, idPergunta=idPerg, correta=False)
            db.session.add(alt3)
            alt4 = Resposta(alternativa=formulario.alt4.data, idDisciplina=idDisc, idProfessor=session['idProf'], idAssunto=idAss, idPergunta=idPerg, correta=False)
            db.session.add(alt4)
            db.session.commit()
            return redirect(url_for('listaPerg', idAssunto=idAss))
        return render_template('insereResposta.html', title='Cadastro de Resposta Alternativa', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/estatistica', methods=['GET', 'POST'])
def estatistica():
    if session.get('logged_in'):
        idperg = request.args['idPergunta']
        hist = Historico.query.filter_by(idPergunta=idperg).count()
        return render_template('estatistica.html', title='Estatítica da Pergunta', hist=hist)
    return redirect(url_for('inicio'))


@app.route('/listar_respostas', methods=['GET', 'POST'])
def listaResp():
    if session.get('logged_in'):
        idperg = request.args['idPergunta']
        resp = Resposta.query.filter_by(idPergunta=idperg).all()
        print(resp)
        return render_template('listaResp.html', title='Respostas', resposta=resp)
    return redirect(url_for('inicio'))

@app.route('/gera_prova', methods=['GET', 'POST'])
def geraProva():
    if session.get('logged_in'):
        disc = Disciplina.query.filter_by(idProfessor=session['idProf']).all()
        list_disc = [(i.idDisciplina, i.nome_disc) for i in disc]
        formulario = FormProva()
        formulario.disciplina.choices = list_disc
        if request.method == 'POST':
            idDisc = formulario.disciplina.data
            anos = formulario.anos.data
            qtd = formulario.perg.data
            anoAtual = formulario.ano_atual.data
            semestreAtual = formulario.semestre.data
            return redirect(url_for('selecionaAssuntos', idDisc=idDisc, anos=anos, qtd=qtd, anoAtual=anoAtual, semestre=semestreAtual))
        return render_template('geraProva.html', title='Gerador de provas', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/seleciona_assuntos', methods=['GET', 'POST'])
def selecionaAssuntos():
    if session.get('logged_in'):
        idDisc = request.args['idDisc']
        nome = Disciplina.query.filter_by(idDisciplina=idDisc).first_or_404()
        anos = request.args['anos']
        semestre = request.args['semestre']
        anoAtual = request.args['anoAtual']
        qtd = request.args['qtd']
        ass = Assunto.query.filter_by(idDisciplina=idDisc).all()
        list_ass = [(i.idAssunto, i.nome_assunto) for i in ass]
        formulario = FormAssuntos()
        formulario.assunto.choices = list_ass
        if request.method == 'POST':
            idAss = formulario.assunto.data
            idsAssuntos = str(idAss.pop(0))
            if not(len(idAss) > 1):
                for i in range(len(idAss)):
                    idsAssuntos = idsAssuntos + "," + str(idAss.pop(i))
            min = str(int(anoAtual) - int(anos))
            if int(anos) == 0:
                vezes = " AND p.idPergunta NOT IN (SELECT h.idPergunta FROM Historico h) "
            else:
                vezes = " AND p.idPergunta IN (SELECT h.idPergunta FROM Historico h INNER JOIN Prova p ON p.idProva = h.idProva WHERE p.ano<" + min + ")"
            sql = "SELECT * FROM Pergunta p INNER JOIN Assunto a ON a.idAssunto = p.idAssunto WHERE p.idAssunto IN (" + idsAssuntos + ")" + vezes + " ORDER BY RANDOM() LIMIT " + str(qtd)
            perg = db.engine.execute(sql)
            prova = Prova(idDisciplina=idDisc, idProfessor=session['idProf'], ano=anoAtual, semestre=semestre)
            db.session.add(prova)
            db.session.flush()
            lista_perg = dict()
            lista_perg['Perguntas'] = []
            for i in perg:
                list = dict()
                list['id'] = i.idPergunta
                list['pergunta'] = i.pergunta
                lista_perg['Perguntas'].append(list)
                hist = Historico( idPergunta=i.idPergunta, idAssunto=i.idAssunto, idDisciplina=i.idDisciplina, idProfessor=session['idProf'], idProva=prova.idProva)
                db.session.add(hist)
            db.session.commit()
            num = Historico.query.filter_by(idProva=prova.idProva).count()
            print(num)
            if num < int(qtd):
                flash('Foram encontradas somente {} perguntas.'.format(num))
            else:
                flash('Prova gerada com sucesso!')
            return render_template('exibeProva.html', title='Prova', lista_perg=lista_perg, disc=nome.nome_disc)
        return render_template('geraProva.html', title='Gerador de provas', form=formulario)
    return redirect(url_for('inicio'))


@app.route('/login', methods=['GET', 'POST'])
def autenticar():
    formulario = LoginForm()
    if formulario.validate_on_submit():
        # fazer a autenticação do usuario
        usuario = Professor.query.filter_by(usuario=formulario.username.data).first_or_404()
        if (usuario.check_password(formulario.password.data)):
            session['logged_in'] = True
            session['usuario'] = usuario.usuario
            session['idProf'] = usuario.idProfessor
            return render_template('autenticado.html', title="Usuário autenticado", user=session.get('usuario'))
        else:
            flash('Usuário ou senha inválidos')
            return redirect(url_for('inicio'))

    return render_template('login.html', title='Autenticação de usuários', form=formulario)


@app.route('/logout')
def sair():
    session['logged_in'] = False
    return redirect(url_for('inicio'))

@app.route('/')
def inicio():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)
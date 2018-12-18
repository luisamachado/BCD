from flask_sqlalchemy import xrange
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField, SelectField, TextAreaField, IntegerField, \
    SelectMultipleField
from wtforms.validators import DataRequired, Length, InputRequired
from wtforms.widgets import ListWidget, CheckboxInput

'''
Veja mais na documentação do WTForms
https://wtforms.readthedocs.io/en/stable/
https://wtforms.readthedocs.io/en/stable/fields.html
Um outro pacote interessante para estudar:
https://wtforms-alchemy.readthedocs.io/en/latest/
'''

class LoginForm(FlaskForm):
    username = StringField('Nome de usuário', validators=[DataRequired("O preenchimento desse campo é obrigatório")])
    password = PasswordField('Senha', validators=[DataRequired("O preenchimento desse campo é obrigatório")])
    submit = SubmitField('Entrar')

class FormDeRegistro(FlaskForm):
    username = StringField('Nome de usuário', validators=[DataRequired(""), Length(max=40)])
    password = PasswordField('Senha', validators=[DataRequired("")])
    submit = SubmitField('Cadastrar')

class FormDisc(FlaskForm):
    nome = StringField('Nome da Disciplina', validators=[DataRequired(""), Length(max=40)])
    submit = SubmitField('Cadastrar')

class FormAssunto(FlaskForm):
    nome = StringField('Assunto', validators=[DataRequired(""), Length(max=40)])
    submit = SubmitField('Cadastrar')

class FormPerg(FlaskForm):
    perg = TextAreaField('Pergunta', validators=[DataRequired(""), Length(max=400)])
    flag = SelectField('Tipo da questão', choices=[('1', 'Múltipla escolha'),('0', 'Discursiva')], validators=[DataRequired("")])
    submit = SubmitField('Cadastrar')

class FormDiscursiva(FlaskForm):
    resp = TextAreaField('Resposta', validators=[DataRequired(""), Length(max=200)])
    submit = SubmitField('Cadastrar')

class FormAlternativa(FlaskForm):
    correta = TextAreaField('Resposta Correta', validators=[DataRequired(""), Length(max=200)])
    alt1 = TextAreaField('Alternativa 1', validators=[DataRequired(""), Length(max=200)])
    alt2 = TextAreaField('Alternativa 2', validators=[DataRequired(""), Length(max=200)])
    alt3 = TextAreaField('Alternativa 3', validators=[DataRequired(""), Length(max=200)])
    alt4 = TextAreaField('Alternativa 4', validators=[DataRequired(""), Length(max=200)])
    submit = SubmitField('Cadastrar')

class FormProva(FlaskForm):
    disciplina = SelectField('Disciplina', coerce=int, validators=[InputRequired])
    perg = IntegerField('Quantidade de perguntas:', validators=[DataRequired("")])
    anos = SelectField('Última vez usada em: (anos)', coerce=int, choices=[(0, 'Nunca usada')] + [(i, i) for i in xrange(1, 15)])
    ano_atual = SelectField('Ano atual:', coerce=int, choices=[(i, i) for i in xrange(2015, 2020)])
    semestre = SelectField('Semestre atual:', coerce=int, choices=[(1, 1), (2, 2)])
    submit = SubmitField('Próximo')

class MultiCheckboxField(SelectMultipleField):
    widget = ListWidget(prefix_label=False)
    option_widget = CheckboxInput()

class FormAssuntos(FlaskForm):
    submit = SubmitField('Gerar')
    assunto = MultiCheckboxField('Assuntos:', coerce=int, validators=[DataRequired("")])


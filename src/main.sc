require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        random:
            a: Привет!
            a: Здравствуй!
            a: Приветствую!

    state: Bye
        intent!: /пока
        random:
            a: Пока!
            a: Всего доброго!

    state: Question
        q!: как дела
        random:
            a: Отлично! 
            a: Чудесно, ведь я общаюсь с тобой :)   
            a: Всё хорошо! 

    state: NoMatch
        event!: noMatch
        random:
            a: Я не понял. Вы сказали: {{$request.query}}. Пожалуйста, переформулируйте!
            a: Извините, я вас не понимаю.

    state: Match
        event!: match
        a: {{$context.intent.answer}}
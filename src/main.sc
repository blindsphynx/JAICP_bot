require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /hello
        random:
            a: Hello!
            a: Hi!
            a: Glad to see you!

    state: Bye
        intent!: /bye
        random:
            a: Bye!
            a: Goodbye!

    state: Question
        q!: * [how are you | what's up] *
        random:
            a: I'm fine, thanks! 
            a: Great, because I'm talking to you :)   
            a: All right! 

    state: NoMatch
        event!: noMatch
        random:
            a: I don't understand. You said: {{$request.query}}
            a: Sorry, I don't understand you.

    state: Match
        event!: match
        a: {{$context.intent.answer}}
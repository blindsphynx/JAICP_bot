require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Start.
        
    state: /SelectOption
        buttons:
            "tell a story"
            "high five!"

    state: Hello
        intent!: /hello
        random:
            a: Hello!
            a: Hi!
            a: Glad to see you, bro!

    state: Bye
        intent!: /bye
        random:
            a: Bye!
            a: See you!

    state: Question
        q!: * [how are you | what's up] *
        random:
            a: I'm fine, thanks! 
            a: Great, because I'm talking to you :)   
            a: All right! 
            a: Fricking cool, bro!
        go: /SelectOption

    state: NoMatch
        event!: noMatch
        random:
            a: Hey, bro, I don't understand. You said: {{$request.query}}
            a: Sorry bro, I don't understand you.

    state: Match
        event!: match
        a: {{$context.intent.answer}}
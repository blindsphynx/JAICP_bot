require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        buttons:
            "what can I do?" -> /MainButtons
        state: ClickButtons
                # q: *
                a: Hey, please choose an option.
                go!: /MainButtons

    state: Hello
        intent!: /hello
        random:
            a: Hello!
            a: Hi!
            a: Glad to see you, bro!
        buttons:
            "ask what's up" -> /HowAreYou
            "say bye" -> /Bye   

    state: Bye
        intent!: /bye
        random:
            a: Bye!
            a: See you!
    
    state: HowAreYou
        q!: [(* how *r* *u * | * what's up) *] 
        random:
            a: I'm fine, thanks! 
            a: Great, because I'm talking to you :)   
            a: All right! 😜
            a: Fricking cool, bro!
        a: Wanna chill?     
        go!: /SelectOption
        buttons:
            "what can I do?" -> ./MainButtons
        
    state: MainButtons
        buttons:
            "say hello" -> /Hello
            "what's up bro?" -> /HowAreYou
            "say bye" -> /Bye
            
    state: /SelectOption
        inlineButtons:
            {text: "chillout music", url: "https://www.youtube.com/watch?v=KuDWifo1q1U&ab_channel=RelaxChilloutMusic"}
            {text: "fancy hip-hop clothes", url: "https://www.everythinghiphop.com/Clothing/"}
    
    state: NoMatch
        event!: noMatch
        random:
            a: Hey, bro, I don't understand. You said: {{$request.query}}
            a: Sorry bro, I don't understand you.

    state: Match
        event!: match
        a: {{$context.intent.answer}}
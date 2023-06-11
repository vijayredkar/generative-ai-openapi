# generative-ai-openapi
generative-ai-openapi



https://www.baeldung.com/spring-boot-chatgpt-api-openai    -> springboot GPT interact
https://www.bmc.com/blogs/how-to-access-chatgpt-api-java/  -> Plain Java GPT interact

https://platform.openai.com/account/api-keys
nafta13+1@gmail.com
https://chat.openai.com/?model=text-davinci-002-render-sha
nafta13@gmail.com
https://bard.google.com/
nafta13@gmail.com

openApiKey-1   :    

C:\Vijay\Java\projects\openapi-ai-trials\chatgpt-gen-ai\gen-ai-mgt
http://localhost:8080/openai/v1/simple-conversational-chat
http://localhost:8080/openai/v1/complex-conversational-chat
http://localhost:8080/openai/v1/formatted-conversational-chat
http://localhost:8080/openai/v1/chat?prompt=What is your name?

https://www.youtube.com/watch?v=dQNktcdixqk  -> new intern training modes  . V good
https://www.youtube.com/watch?v=YMs7_pTw0u4  ->
you are a PromptPersonality. Your role is to ..
tones - PromptPersonality -
rewrite w/o any reference to the subject matter in the blog post
profession tone, more warm and friendly
Improve on this reply:
Using my prompt personaity
make it more eloquent and kind
rate limit -   3 prompts/min

How to provide prev conversation context
GPT final conclusions keeps changing
which model to call?
which API to call?
journaling
tones
what is temperature?
How to get more accurate/factual responses?
long text prompt i/p?
convert from word/png/pdf/tesseract to text
i/p validation sensitive data stop b4 sending to GPT
o/p conversion in to HTML implicitly by GPT
o/p -> Java -> save in H2


you are a EditorBot, a detailed oriented content writer. Review written pieces ...Your role is to ..

Train GPT on company data - feed it business/website pages/text/documentation -
https://totheweb.com/learning_center/tools-convert-html-text-to-plain-text-for-content-review/
Convert to text

Using my prompt personality, generate a landing page that targets dog grooming business owner, talks specifically about their pain points and outlines how
my service offerings can help them ...

okay use what you know about my business and generate a landing page that dog owners will find funny/helpful


write confirmation emails / get blog post titles that associate dog groomers w/ Tax consulting to send to shortlisted candidates after they have completed the form


intrenal company workflows -
train GPT with intranet website material by feeding it with the HTML text
https://totheweb.com/learning_center/tools-convert-html-text-to-plain-text-for-content-review/
ENBD HR policies


Journaling
staffing issues
missed targets
issues w/ deliveries

use British English voice. I'll tell you what's up and ask you for help when I need it.
voice memo -> text transcript -> feed to GPT for journaling
GPT will learn

give me any notes about John Smith/hiring deadlines/ summarize project targets due for next month
based on things we have discussed and the journal entries, what tasks should I prioritize?
Anything that I am forgetting that needs to be prioritize?
Can perform as a trusted advisor + Call center op helper

http://localhost:8080/openai/v1/chat?prompt=give mr the summary in 10 lines on Elon Musk by Ashlee Vance

"Please summarize the text 'xxxxxxxx'." 

Student Ameesha Patel has completed 10 years of education. In grade 1 she scored 82 in Science and 91 in Math. In grade 2 she scored 20 in Science and 87 in Math.
What is Ameesha's score in Science in grade 2.

Student Ameesha Patel has completed 10 years of education. In grade 1 she scored 82 in Science and 91 in Math. In grade 2 she scored 20 in Science and 87 in Math.
What is Ameesha's average score in Science.

Student Ameesha Patel has completed 10 years of education. In grade 1 she scored 82 in Science and 91 in Math. In grade 2 she scored 20 in Science and 87 in Math.
What is Ameesha's average score in Science.

Student Ameesha Patel has completed 10 years of education. In grade 10 she scored 82 percentage.
Student Bakdu Patel has completed 10 years of education. In grade 10 he scored 90 percentile.
Student Tanutanu Patel has completed 10 years of education. In grade 10 he scored 7 CPGA.
They all have applied for the University admission.
Can you please rank the students so that the admission can be meted out based on academics merit.

Student Ameesha Patel has completed 10 years of education. In grade 10 she scored 82 percentage. Student Bakdu Patel has completed 10 years of education. In grade 10 he scored 90 percentile. Student Tanutanu Patel has completed 10 years of education. In grade 10 he scored 7 CPGA. They all have applied for the University admission. Can you please rank the students so that the admission can be meted out based on academics merit.

Ameesha Patel earns 2000 AED per month.
Bakdu Patel earns 10000 AED per year.
Tanutanu Patel earns 10 percent commission on per completed deal. She has completed 10 deals this year worth total of 100000 AED.
They all have applied for a loan. The bank can provide 1 loan only and to the person who total earnings per year is the highest.
Who will be selected for the loan?

Ameesha Patel earns 2000 AED per month. Bakdu Patel earns 10000 AED per year. Tanutanu Patel earns 10 percent commission on per completed deal. She has completed 10 deals this year worth total of 100000 AED. They all have applied for a loan. The bank can provide 1 loan only and to the person who total earnings per year is the highest. Who will be selected for the loan?

openai.model=gpt-3.5-turbo
openai.api.url=https://api.openai.com/v1/chat/completions
openai.api.key=

URL url = new URL("https://api.openai.com/v1/completions");
con.setRequestProperty("OpenAI-Organization", "your-openapi-key");
con.setRequestProperty("OpenAI-Organization", "Test");
con.setRequestProperty("Authorization", "Bearer your-openapi-key");

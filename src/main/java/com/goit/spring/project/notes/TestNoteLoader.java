package com.goit.spring.project.notes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestNoteLoader implements CommandLineRunner {
    private final NoteServiceInterface noteService;

    public TestNoteLoader(NoteServiceInterface noteService) {
        this.noteService = noteService;
    }

    @Override
    public void run(String... args) {
        if (!noteService.listAll().isEmpty()) return;
        System.out.println("Loading project documentation notes...");

        noteService.add(new Note(
                "Thymeleaf Layout Integration",
                "This project uses Thymeleaf layout fragments to structure HTML views. The layout.html file defines reusable head and body sections. Child pages like list.html replace those sections with their own content via th:replace and th:fragment, enabling DRY templating."
        ));

        noteService.add(new Note(
                "How Notes Are Injected",
                "The NoteService manages in-memory notes. On app startup, TestNoteLoader preloads five meaningful notes. Notes are injected into the HTML via a controller that adds them to the model and renders the list.html template."
        ));

        noteService.add(new Note(
                "Card UI with Bootstrap",
                "Notes are displayed as responsive Bootstrap cards with the title on top. Each card is clickable (to view the full note) and includes an Edit button. Long content is truncated using Thymeleaf's #strings.abbreviate(...) for a cleaner UI."
        ));

        noteService.add(new Note(
                "Global + Button",
                "A + button is added to the layout and appears on every page. It uses Bootstrap styling and a fixed position to stay accessible. This allows users to add a new note anytime. Tooltip text explains its function on hover."
        ));

        noteService.add(new Note(
                "Project Structure Explained",
                "The backend follows a clean package structure: controllers in 'controller', services in 'service', and data in 'model'. HTML templates live under 'resources/templates'. Static assets like CSS are under 'resources/static'. This separation keeps code organized and scalable."
        ));
        noteService.add(new Note(
                "Thymeleaf vs the Phantom Button",
                "One mystery button refused to show. Turned out to be a missing th:replace syntax. Fixed it with ~{} and a side-eye at the old docs."
        ));

        noteService.add(new Note(
                "Floating + Button Alignment War",
                "Centering a + inside a circle is harder than it looks. Flexbox won the war, and -3px margin was the hero nobody expected."
        ));

        noteService.add(new Note(
                "Card Grid Chaos",
                "Cards were clinging to each other like scared cats. Bootstrap's grid system and spacing utilities saved the day. Meow."
        ));

        noteService.add(new Note(
                "Dynamic Back Link",
                "Implemented a dynamic 'Back to list' link using a boolean flag in the model. Conditional rendering in Thymeleaf = 💡 moment."
        ));

        noteService.add(new Note(
                "Tooltip Time",
                "Hovering the + now whispers: 'Write a new note'. Bootstrap tooltips + one line of code = instant UX magic."
        ));

        noteService.add(new Note(
                "Consistent Layout Everywhere",
                "Thymeleaf fragments were used to define head and layout templates. Every view now inherits a consistent structure."
        ));

        noteService.add(new Note(
                "Spring Boot Makes It Easy",
                "No XML config, no stress. Spring Boot + @Component + @Controller = minimal boilerplate, maximum productivity."
        ));

        noteService.add(new Note(
                "Console Logging as Debug Therapy",
                "System.out.println became our best friend. Forget breakpoints—print and vibe."
        ));

        noteService.add(new Note(
                "When in Doubt, Flex It Out",
                "Aligning buttons, centering cards, vertical spacing — Flexbox handled it like a champ."
        ));

        noteService.add(new Note(
                "Surprise Bug: Card Not Clickable",
                "Thymeleaf escaped the click event quotes. We fixed it by manually escaping single quotes inside the onclick attribute. A tiny battle won."
        ));

        noteService.add(new Note(
                "Adding Notes Without Model Binding",
                "For simplicity, we used plain <input name='...'> instead of a full model object. Lightweight and it just worked™."
        ));

        noteService.add(new Note(
                "Why We Didn’t Use JavaScript",
                "To focus on core HTML, CSS, and Spring concepts. No distractions. Pure backend and template power."
        ));

        noteService.add(new Note(
                "Joke Break – Developer Wisdom",
                "Why do Java devs wear glasses? Because they can't C# 😎"
        ));

        noteService.add(new Note(
                "Minimal But Mighty",
                "No database. No Spring Data. Just a clean, in-memory app that showcases CRUD, layouting, and MVC flow."
        ));

        noteService.add(new Note(
                "Classy File Structure",
                "Separation of concerns: notes, sandbox, exceptions, layout. Even the notes got their own folder — because they matter."
        ));

        noteService.add(new Note(
                "Lessons Learned",
                "You don’t need a big tech stack to make something clean, usable, and beautiful. Just patience, flexbox, and some good old problem-solving."
        ));

        noteService.add(new Note(
                "Real Final Boss: Auto-formatter",
                "Prettified your code? Surprise, IntelliJ rearranged it again. You can never win against it. Accept the chaos."
        ));

        noteService.add(new Note(
                "The Plus Button Has Personality Now",
                "Green, round, hovers smoothly, and glows with Bootstrap confidence. She’s cute, but she’s functional."
        ));

        noteService.add(new Note(
                "Style.css Was a Battlefield",
                "What started simple turned into a full-on CSS chess match. The only rule: override Bootstrap, but respectfully."
        ));
        noteService.add(new Note(
                "Switching to H2: Flyway Didn’t Fly",
                "Initial migration script was ignored because the note table didn’t exist at runtime. The fix? Configure Flyway correctly and name your migration file `V1__create_note.sql` with double underscores."
        ));

        noteService.add(new Note(
                "Persistent Pain: H2 Didn’t Save",
                "Used `jdbc:h2:mem:notesdb`, but wondered where the data went. In-memory databases reset on each run. Changed to `jdbc:h2:file:./data/notesdb` to make the data persistent."
        ));

        noteService.add(new Note(
                "Flyway Worked, But Hibernate Complained",
                "Flyway created the table, but Hibernate couldn’t validate it. Root cause? `ddl-auto=validate` expected perfect match. Fixed by syncing entity field types and column definitions."
        ));

        noteService.add(new Note(
                "InMemory vs H2: Constructor Confusion",
                "InMemory accepted any Note, but H2 required an ID strategy. Added `@GeneratedValue(strategy = GenerationType.IDENTITY)` to fix auto-generation errors when switching to JPA."
        ));

        noteService.add(new Note(
                "Debugging Nightmares",
                "Programmer enters a bar. Then another. And another. The problem? A missing 'break' in his for loop."
        ));

        noteService.add(new Note(
                "Ukrainian Cache Wipe",
                "A student deleted all folders with 'cache' in the name before an exam. He thought it meant 'качати' — to overload the brain. The project stopped compiling, but he felt lighter."
        ));

        noteService.add(new Note(
                "Babushka’s Java Wisdom",
                "— Grandma, I wrote a Java program!\n— Did you feed it? Turn off the light when it sleeps!"
        ));

        noteService.add(new Note(
                "Coffee Overflow",
                "Java developer ran out of coffee. He rebooted his router, hoping the caffeine would reset remotely."
        ));

        noteService.add(new Note(
                "Eternal Commit",
                "Git commit message: 'final final version REAL FINAL now 100% FINAL'. Spoiler: wasn’t final."
        ));

        noteService.add(new Note(
                "IntelliJ Haunting",
                "Every time I close IntelliJ, I see error traces in my dreams. StackOverflowException included."
        ));

        noteService.add(new Note(
                "The Junior’s Legend",
                "Junior dev fixed a bug by renaming the variable. Bug disappeared. Senior still investigating."
        ));

        noteService.add(new Note(
                "Ukrainian If Statement",
                "If (cold) wear_shuba(); else if (very_cold) drink_horilka(); else code_as_usual();"
        ));

        noteService.add(new Note(
                "Unexpected Merge",
                "‘Let’s just merge it quickly before lunch.’ Famous last words before a 3-day rollback mission."
        ));

        noteService.add(new Note(
                "Keyboard Duel",
                "Senior: 'Don’t touch my code!'\nJunior: 'Then don’t commit bugs.'\nAnd thus the office war began."
        ));

        noteService.add(new Note(
                "Debugging Nightmares",
                "Programmer enters a bar. Then another. And another. The problem? A missing 'break' in his for loop."
        ));

        noteService.add(new Note(
                "Ukrainian Cache Wipe",
                "A student deleted all folders with 'cache' in the name before an exam. He thought it meant 'качати' — to overload the brain. The project stopped compiling, but he felt lighter."
        ));

        noteService.add(new Note(
                "Babushka’s Java Wisdom",
                "— Grandma, I wrote a Java program!\n— Did you feed it? Turn off the light when it sleeps!"
        ));

        noteService.add(new Note(
                "Coffee Overflow",
                "Java developer ran out of coffee. He rebooted his router, hoping the caffeine would reset remotely."
        ));

        noteService.add(new Note(
                "Eternal Commit",
                "Git commit message: 'final final version REAL FINAL now 100% FINAL'. Spoiler: wasn’t final."
        ));

        noteService.add(new Note(
                "IntelliJ Haunting",
                "Every time I close IntelliJ, I see error traces in my dreams. StackOverflowException included."
        ));

        noteService.add(new Note(
                "The Junior’s Legend",
                "Junior dev fixed a bug by renaming the variable. Bug disappeared. Senior still investigating."
        ));

        noteService.add(new Note(
                "Ukrainian If Statement",
                "If (cold) wear_shuba(); else if (very_cold) drink_horilka(); else code_as_usual();"
        ));

        noteService.add(new Note(
                "Unexpected Merge",
                "‘Let’s just merge it quickly before lunch.’ Famous last words before a 3-day rollback mission."
        ));

        noteService.add(new Note(
                "Keyboard Duel",
                "Senior: 'Don’t touch my code!'\nJunior: 'Then don’t commit bugs.'\nAnd thus the office war began."
        ));

        noteService.add(new Note(
                "NullPointer and Chill",
                "Planned to relax after fixing bugs. Got a NullPointerException in production. Relax canceled."
        ));

        noteService.add(new Note(
                "Babushka vs AI",
                "Tried explaining AI to my babushka. She said, 'So it’s like your old Tamagotchi, but it types?'"
        ));

        noteService.add(new Note(
                "One Does Not Simply",
                "One does not simply change database schema on Friday. Unless you enjoy chaos and coffee at 3 AM."
        ));

        noteService.add(new Note(
                "Ukrainian Unit Test",
                "assertThat(borsch.contains('meat')).isTrue(); assertThat(borsch.isDelicious()).isTrue();"
        ));

        noteService.add(new Note(
                "25. The Senior Awakens",
                "Junior: ‘It works!’\nSenior: ‘That’s suspicious.’\nNo line of code is ever truly innocent."
        ));

        noteService.add(new Note(
                "While True, Hope",
                "while (true) { deploy(); hope(); cry(); } // classic DevOps loop"
        ));

        noteService.add(new Note(
                "Ukrainian Frontend Dev",
                "Says: 'I'm not a designer.' Then opens Figma anyway... and regrets everything."
        ));

        noteService.add(new Note(
                "Breakpoint Addiction",
                "Said I’d add one breakpoint. Ended up debugging the entire life cycle of a button."
        ));

        noteService.add(new Note(
                "Stack Overflow Therapy",
                "Some talk to therapists. I paste code into Stack Overflow and wait for judgment and healing."
        ));

        noteService.add(new Note(
                "The Final Commit",
                "Commit message: ‘Final fix. No more bugs. Seriously.’ App crashes immediately after deployment. Classic."
        ));


        System.out.println("Project documentation notes loaded.");
    }


}

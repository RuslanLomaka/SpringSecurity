package com.goit.spring.project.notes;

import org.springframework.stereotype.Component;

@Component
public class TestNoteLoader {

    public TestNoteLoader(NoteService noteService) {
        System.out.println("Loading project documentation notes...");

        noteService.add(new Note(
                "1. Thymeleaf Layout Integration",
                "This project uses Thymeleaf layout fragments to structure HTML views. The layout.html file defines reusable head and body sections. Child pages like list.html replace those sections with their own content via th:replace and th:fragment, enabling DRY templating."
        ));

        noteService.add(new Note(
                "2. How Notes Are Injected",
                "The NoteService manages in-memory notes. On app startup, TestNoteLoader preloads five meaningful notes. Notes are injected into the HTML via a controller that adds them to the model and renders the list.html template."
        ));

        noteService.add(new Note(
                "3. Card UI with Bootstrap",
                "Notes are displayed as responsive Bootstrap cards with the title on top. Each card is clickable (to view the full note) and includes an Edit button. Long content is truncated using Thymeleaf's #strings.abbreviate(...) for a cleaner UI."
        ));

        noteService.add(new Note(
                "4. Global + Button",
                "A + button is added to the layout and appears on every page. It uses Bootstrap styling and a fixed position to stay accessible. This allows users to add a new note anytime. Tooltip text explains its function on hover."
        ));

        noteService.add(new Note(
                "5. Project Structure Explained",
                "The backend follows a clean package structure: controllers in 'controller', services in 'service', and data in 'model'. HTML templates live under 'resources/templates'. Static assets like CSS are under 'resources/static'. This separation keeps code organized and scalable."
        ));
        noteService.add(new Note(
                "6. Thymeleaf vs the Phantom Button",
                "One mystery button refused to show. Turned out to be a missing th:replace syntax. Fixed it with ~{} and a side-eye at the old docs."
        ));

        noteService.add(new Note(
                "7. Floating + Button Alignment War",
                "Centering a + inside a circle is harder than it looks. Flexbox won the war, and -3px margin was the hero nobody expected."
        ));

        noteService.add(new Note(
                "8. Card Grid Chaos",
                "Cards were clinging to each other like scared cats. Bootstrap's grid system and spacing utilities saved the day. Meow."
        ));

        noteService.add(new Note(
                "9. Dynamic Back Link",
                "Implemented a dynamic 'Back to list' link using a boolean flag in the model. Conditional rendering in Thymeleaf = 💡 moment."
        ));

        noteService.add(new Note(
                "10. Tooltip Time",
                "Hovering the + now whispers: 'Write a new note'. Bootstrap tooltips + one line of code = instant UX magic."
        ));

        noteService.add(new Note(
                "11. Consistent Layout Everywhere",
                "Thymeleaf fragments were used to define head and layout templates. Every view now inherits a consistent structure."
        ));

        noteService.add(new Note(
                "12. Spring Boot Makes It Easy",
                "No XML config, no stress. Spring Boot + @Component + @Controller = minimal boilerplate, maximum productivity."
        ));

        noteService.add(new Note(
                "13. Console Logging as Debug Therapy",
                "System.out.println became our best friend. Forget breakpoints—print and vibe."
        ));

        noteService.add(new Note(
                "14. When in Doubt, Flex It Out",
                "Aligning buttons, centering cards, vertical spacing — Flexbox handled it like a champ."
        ));

        noteService.add(new Note(
                "15. Surprise Bug: Card Not Clickable",
                "Thymeleaf escaped the click event quotes. We fixed it by manually escaping single quotes inside the onclick attribute. A tiny battle won."
        ));

        noteService.add(new Note(
                "16. Adding Notes Without Model Binding",
                "For simplicity, we used plain <input name='...'> instead of a full model object. Lightweight and it just worked™."
        ));

        noteService.add(new Note(
                "17. Why We Didn’t Use JavaScript",
                "To focus on core HTML, CSS, and Spring concepts. No distractions. Pure backend and template power."
        ));

        noteService.add(new Note(
                "18. Joke Break – Developer Wisdom",
                "Why do Java devs wear glasses? Because they can't C# 😎"
        ));

        noteService.add(new Note(
                "19. Minimal But Mighty",
                "No database. No Spring Data. Just a clean, in-memory app that showcases CRUD, layouting, and MVC flow."
        ));

        noteService.add(new Note(
                "20. Classy File Structure",
                "Separation of concerns: notes, sandbox, exceptions, layout. Even the notes got their own folder — because they matter."
        ));

        noteService.add(new Note(
                "21. Lessons Learned",
                "You don’t need a big tech stack to make something clean, usable, and beautiful. Just patience, flexbox, and some good old problem-solving."
        ));

        noteService.add(new Note(
                "22. Real Final Boss: Auto-formatter",
                "Prettified your code? Surprise, IntelliJ rearranged it again. You can never win against it. Accept the chaos."
        ));

        noteService.add(new Note(
                "23. The Plus Button Has Personality Now",
                "Green, round, hovers smoothly, and glows with Bootstrap confidence. She’s cute, but she’s functional."
        ));

        noteService.add(new Note(
                "24. Style.css Was a Battlefield",
                "What started simple turned into a full-on CSS chess match. The only rule: override Bootstrap, but respectfully."
        ));


        System.out.println("Project documentation notes loaded.");
    }
}

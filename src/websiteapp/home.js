document.addEventListener('DOMContentLoaded', () => {
    const tabs = document.querySelectorAll('.tab-btn');
    const tabContents = document.querySelectorAll('.tab-content');

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            const targetTab = tab.getAttribute('data-tab');

            tabContents.forEach(content => {
                content.classList.add('hidden');
                content.classList.remove('active');
            });

            document.getElementById(targetTab).classList.remove('hidden');
            document.getElementById(targetTab).classList.add('active');
        });
    });

    // Set the default tab
    document.getElementById('about-us').classList.add('active');
});

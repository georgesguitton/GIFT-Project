/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,jsp,tag}"],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms'),
  ],
}

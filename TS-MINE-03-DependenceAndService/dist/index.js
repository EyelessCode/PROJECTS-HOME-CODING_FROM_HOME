import express from 'express';
const app = express();
const PORT = 4000;
app.use(express.json());
app.get('/', (req, res) => {
    res.send("Hello World!");
});
app.listen(PORT, () => console.log(`Server listening in PORT number: ${PORT}`));
//# sourceMappingURL=index.js.map